package com.main.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.model.Drug;
import com.main.model.Representative;
import com.main.repository.DrugRepository;
import com.main.repository.RepresentativeRepository;
import com.main.util.ResponseMessage;

@Service
@Transactional(rollbackFor = Throwable.class)
public class RepresentativeServiceImpl implements RepresentativeService {
	@Autowired
	RepresentativeRepository representativeRepository;

	@Autowired
	DrugRepository drugRepository;
	@Autowired
	ResponseMessage responseMessage;

	@Override
	public ResponseMessage CreateRepresentative(Representative representative) {
		if (representativeRepository
				.findByRepresentativeEmployeeId(representative
						.getRepresentativeEmployeeId()) != null) {

			responseMessage.setStatus("exists");
			responseMessage.setMessage("Representative id already exists");
			return responseMessage;
		} else {
			for (Drug drug : representative.getDrug()) {
				drug.setRepresentativeEmployeeId(representative
						.getRepresentativeEmployeeId());
			}
			representativeRepository.save(representative);
			drugRepository.save(representative.getDrug());
			return representative;
		}
	}

	@Override
	public ResponseMessage UpdateRepresentative(Representative representative) {
		Representative r = representativeRepository
				.findByRepresentativeEmployeeId(representative
						.getRepresentativeEmployeeId());
		if (r == null) {
			responseMessage.setStatus("notFound");
			responseMessage.setMessage("Representative id not found");
			return responseMessage;
		}
		representative.setId(r.getId());
		List<String> drugNameList = new ArrayList<>();
		for (Drug drug : representative.getDrug()) {
			drug.setRepresentativeEmployeeId(representative
					.getRepresentativeEmployeeId());
			drugNameList.add(drug.getName());
		}
		List<Drug> drugList = drugRepository
				.findByNameInAndRepresentativeEmployeeId(drugNameList,
						representative.getRepresentativeEmployeeId());
		representativeRepository.save(representative);
		drugRepository.delete(drugList);
		drugRepository.save(representative.getDrug());
		return representative;
	}

	@Override
	public ResponseMessage DeleteRepresentativeById(int id) {
		Representative representative = representativeRepository
				.findByRepresentativeEmployeeId(id);
		if (representative == null) {
			responseMessage.setStatus("notFound");
			responseMessage.setMessage("Representative id not found");
			return responseMessage;
		} else {
			drugRepository.deleteByRepresentativeEmployeeId(id);
			representativeRepository.deleteByRepresentativeEmployeeId(id);
			responseMessage.setStatus("ok");
			responseMessage.setMessage("Representative deleted");
			return responseMessage;
		}
	}

	@Override
	public ResponseMessage GetRepresentativeById(int id) {
		Representative representative = representativeRepository
				.findByRepresentativeEmployeeId(id);
		if (representative == null) {
			responseMessage.setStatus("notFound");
			responseMessage.setMessage("Representative id not found");
			return responseMessage;
		}
		Set<Drug> drugSet = new HashSet<>();
		drugSet = drugRepository.findByRepresentativeEmployeeId(id);
		representative.setDrug(drugSet);
		return representative;
	}

	@Override
	public Object GetAllRepresentative() {
		List<Representative> representatives= representativeRepository.findAll();
		if(representatives.size()==0){
			return null;
		}
		return representativeRepository.findAll();
	}

}
