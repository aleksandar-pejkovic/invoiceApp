package com.alpey.invoice.utils.convertable;

public interface ConvertableToRequest<T, K> {

	K convertToRequest(T t);

}
