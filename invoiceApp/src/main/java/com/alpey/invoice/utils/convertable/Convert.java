package com.alpey.invoice.utils.convertable;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Convert<T, K> implements ConvertableToDto<T, K>, ConvertableToEntity<T, K>,
		ConvertableToRequest<T, K>, ConvertableToResponse<T, K> {

	@Autowired
	ModelMapper mapper;

	@Override
	public K convertToResponse(T t) {
		K k = null;
		mapper.map(t, k);
		return k;
	}

	@Override
	public K convertToRequest(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T convertToEntity(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K convertToDto(T t) {
		// TODO Auto-generated method stub
		return null;
	}


}
