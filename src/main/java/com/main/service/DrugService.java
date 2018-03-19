package com.main.service;

import com.main.util.ResponseMessage;

public interface DrugService {

	public ResponseMessage DeleteDrugByIdAndName(int id, String name);
}
