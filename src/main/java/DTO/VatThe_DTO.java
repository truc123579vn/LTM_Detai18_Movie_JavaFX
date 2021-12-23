package DTO;

public class VatThe_DTO {
    private String Object;
    private Double PercentObject;

    public VatThe_DTO(String object, Double percentObject) {
        Object = object;
        PercentObject = percentObject;
    }

    public String getObject() {
        return Object;
    }

    public void setObject(String object) {
        Object = object;
    }

    public Double getPercentObject() {
        return PercentObject;
    }

    public void setPercentObject(Double percentObject) {
        PercentObject = percentObject;
    }
}
