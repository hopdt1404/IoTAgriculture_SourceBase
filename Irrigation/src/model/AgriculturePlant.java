package model;

public class AgriculturePlant {
    private Long id;
    private Long plantId;
    private Integer plantStateId;
    private Long plotId;
    private Integer growthPeriod;
    private Float temperature;
    private Float moisture;
//    private String light;
//    private String note;
//    private Timestamp createdAt;
//    private String createdUser;
//    private Timestamp updatedAt;
//    private String updatedUser;

    public AgriculturePlant(AgriculturePlant agriculturePlant)
    {
        this.id = agriculturePlant.id;
        this.plantId = agriculturePlant.plantId;
        this.plantStateId = agriculturePlant.plantStateId;
        this.plotId = agriculturePlant.plotId;
        this.growthPeriod = agriculturePlant.growthPeriod;
        this.temperature = agriculturePlant.temperature;
        this.moisture = agriculturePlant.moisture;
    }
    public AgriculturePlant(Long id, Long plantId,
                            Integer plantStateId, Long PlotId,
                            Integer growthPeriod,
                            Float temperature, Float moisture)
    {
        this.id = id;
        this.plantId = plantId;
        this.plantStateId = plantStateId;
        this.plotId = PlotId;
        this.growthPeriod = growthPeriod;
        this.temperature = temperature;
        this.moisture = moisture;
    }
    @Override
    public String toString() {
        System.out.println("AgriculturePlant Model: \n");
        return "id: "+this.id+", plantId: "+this.plantId+
                ", plantStateId: "+this.plantStateId+", PlotID: "+this.plotId+
                ", growthPeriod: "+this.growthPeriod+
                ", temperature: "+this.temperature+'\n' +", moisture" + this.moisture;
    }
    public Long getPlantId() {
        return this.plantId;
    }
    public Integer getPlantStateId () {
        return this.plantStateId;
    }
    public Long getPlotId () {
        return this.plotId;
    }
    public Float getTemperature() {
        return this.temperature;
    }
    public Float getMoisture() {
        return this.moisture;
    }
}
