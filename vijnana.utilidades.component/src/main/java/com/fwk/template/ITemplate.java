package com.fwk.template;

import java.util.Map;

public abstract interface ITemplate
{
  public abstract String getBodyByTemplate(String paramString1, Map<String, String> paramMap, String paramString2);
}