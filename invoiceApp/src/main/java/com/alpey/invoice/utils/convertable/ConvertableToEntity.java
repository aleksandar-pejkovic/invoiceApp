package com.alpey.invoice.utils.convertable;

public interface ConvertableToEntity<T, K> {

	T convertToEntity(K k);

}
