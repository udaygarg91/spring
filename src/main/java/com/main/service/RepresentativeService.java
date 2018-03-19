package com.main.service;

import com.main.model.Representative;
import com.main.util.ResponseMessage;

public interface RepresentativeService {

	public ResponseMessage CreateRepresentative(Representative representative);

	public ResponseMessage UpdateRepresentative(Representative representative);

	public ResponseMessage DeleteRepresentativeById(int id);

	public ResponseMessage GetRepresentativeById(int id);

	public Object GetAllRepresentative();
}
