package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.model.Drug;
import com.main.repository.DrugRepository;
import com.main.util.ResponseMessage;

@Service
@Transactional(rollbackFor = Throwable.class)
public class DrugServiceImpl implements DrugService {
	@Autowired
	DrugRepository drugRepository;
	@Autowired
	ResponseMessage responseMessage;

	@Override
	public ResponseMessage DeleteDrugByIdAndName(int id, String name) {
		Drug drug = drugRepository.findByNameAndRepresentativeEmployeeId(name,
				id);
		if (drug == null) {
			responseMessage.setStatus("notFound");
			responseMessage.setMessage("Drug not found");
			return responseMessage;
		}
		drugRepository.delete(drug);
		responseMessage.setStatus("ok");
		responseMessage.setMessage("Drug deleted");
		return responseMessage;
	}
}
