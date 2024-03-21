package models;

import java.util.List;

public class QueryRequestModel {
    private final String queryString;
    private List<String> parameterNames;
    private List<String> parameterValues;

    public QueryRequestModel(String queryString, List<String> parameterNames, List<String> parameterValues) {
        this.queryString = queryString;
        this.parameterNames = parameterNames;
        this.parameterValues = parameterValues;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setParameterValues(List<String> parameterValues) {
        this.parameterValues = parameterValues;
    }

    public List<String> getParameterNames() {
        return parameterNames;
    }

    public void setParameterNames(List<String> parameterNames) {
        this.parameterNames = parameterNames;
    }

    public List<String> getParameterValues() {
        return parameterValues;
    }

    public Integer getNumberOfParameters() {
        assert parameterNames.size() == parameterValues.size();

        return parameterNames.size();
    }
}
