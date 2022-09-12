package com.mphasis3._User_Authentication;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;



public class ParamResolve implements ParameterResolver {
	@Override
	public Object resolveParameter(ParameterContext parameterContext,  ExtensionContext extensionContext) throws ParameterResolutionException {
	    return new Validate();
	}

	@Override
	public boolean supportsParameter(ParameterContext parameterContext,ExtensionContext extensionContext) throws ParameterResolutionException {
	    return parameterContext.getParameter().getType() == Validate.class;
	}
}
