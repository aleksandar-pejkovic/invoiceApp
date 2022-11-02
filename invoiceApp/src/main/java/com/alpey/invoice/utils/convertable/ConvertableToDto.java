package com.alpey.invoice.utils.convertable;

public interface ConvertableToDto<T, K> {

	K convertToDto(T t);

}
