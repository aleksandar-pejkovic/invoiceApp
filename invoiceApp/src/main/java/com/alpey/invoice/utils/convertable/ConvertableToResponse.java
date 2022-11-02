package com.alpey.invoice.utils.convertable;

public interface ConvertableToResponse<T, K> {

	K convertToResponse(T t);

}
