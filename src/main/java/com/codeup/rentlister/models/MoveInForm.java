package com.codeup.rentlister.models;
import jakarta.persistence.*;
@Entity
@Table(name = "MoveInForm")
public class MoveInForm {
    public MoveInForm() {

    }

    @Override
    public String toString() {
        return "MoveInForm{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", inspectionDate='" + inspectionDate + '\'' +
                ", foundationCondition=" + foundationCondition +
                ", foundationRemarks='" + foundationRemarks + '\'' +
                ", wallsECondition=" + wallsECondition +
                ", wallsERemarks='" + wallsERemarks + '\'' +
                ", roofCondition=" + roofCondition +
                ", roofRemarks='" + roofRemarks + '\'' +
                ", electricECondition=" + electricECondition +
                ", electricERemarks='" + electricERemarks + '\'' +
                ", windowECondition=" + windowECondition +
                ", windowERemarks='" + windowERemarks + '\'' +
                ", doorECondition=" + doorECondition +
                ", doorERemarks='" + doorERemarks + '\'' +
                ", gutterCondition=" + gutterCondition +
                ", gutterRemarks='" + gutterRemarks + '\'' +
                ", shutterCondition=" + shutterCondition +
                ", shutterRemarks='" + shutterRemarks + '\'' +
                ", floorCondition=" + floorCondition +
                ", floorRemarks='" + floorRemarks + '\'' +
                ", wallsICondition=" + wallsICondition +
                ", wallsIRemarks='" + wallsIRemarks + '\'' +
                ", ceilingCondition=" + ceilingCondition +
                ", ceilingRemarks='" + ceilingRemarks + '\'' +
                ", electricICondition=" + electricICondition +
                ", electricIRemarks='" + electricIRemarks + '\'' +
                ", windowICondition=" + windowICondition +
                ", windowIRemarks='" + windowIRemarks + '\'' +
                ", doorICondition=" + doorICondition +
                ", doorIRemarks='" + doorIRemarks + '\'' +
                ", closetCondition=" + closetCondition +
                ", closetRemarks='" + closetRemarks + '\'' +
                ", stoveCondition=" + stoveCondition +
                ", stoveRemarks='" + stoveRemarks + '\'' +
                ", coolCondition=" + coolCondition +
                ", coolRemarks='" + coolRemarks + '\'' +
                ", heatCondition=" + heatCondition +
                ", heatRemarks='" + heatRemarks + '\'' +
                ", electricCondition=" + electricCondition +
                ", electricRemarks='" + electricRemarks + '\'' +
                ", plumbCondition=" + plumbCondition +
                ", plumbRemarks='" + plumbRemarks + '\'' +
                ", securityCondition=" + securityCondition +
                ", securityRemarks='" + securityRemarks + '\'' +
                ", garageCondition=" + garageCondition +
                ", garageRemarks='" + garageRemarks + '\'' +
                ", waterCondition=" + waterCondition +
                ", waterRemarks='" + waterRemarks + '\'' +
                ", sprinklerCondition=" + sprinklerCondition +
                ", sprinklerRemarks='" + sprinklerRemarks + '\'' +
                ", softenerCondition=" + softenerCondition +
                ", softenerRemarks='" + softenerRemarks + '\'' +
                ", agreeCheck=" + agreeCheck +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public InspectionCondition getFoundationCondition() {
        return foundationCondition;
    }

    public void setFoundationCondition(InspectionCondition foundationCondition) {
        this.foundationCondition = foundationCondition;
    }

    public String getFoundationRemarks() {
        return foundationRemarks;
    }

    public void setFoundationRemarks(String foundationRemarks) {
        this.foundationRemarks = foundationRemarks;
    }

    public InspectionCondition getWallsECondition() {
        return wallsECondition;
    }

    public void setWallsECondition(InspectionCondition wallsECondition) {
        this.wallsECondition = wallsECondition;
    }

    public String getWallsERemarks() {
        return wallsERemarks;
    }

    public void setWallsERemarks(String wallsERemarks) {
        this.wallsERemarks = wallsERemarks;
    }

    public InspectionCondition getRoofCondition() {
        return roofCondition;
    }

    public void setRoofCondition(InspectionCondition roofCondition) {
        this.roofCondition = roofCondition;
    }

    public String getRoofRemarks() {
        return roofRemarks;
    }

    public void setRoofRemarks(String roofRemarks) {
        this.roofRemarks = roofRemarks;
    }

    public InspectionCondition getElectricECondition() {
        return electricECondition;
    }

    public void setElectricECondition(InspectionCondition electricECondition) {
        this.electricECondition = electricECondition;
    }

    public String getElectricERemarks() {
        return electricERemarks;
    }

    public void setElectricERemarks(String electricERemarks) {
        this.electricERemarks = electricERemarks;
    }

    public InspectionCondition getWindowECondition() {
        return windowECondition;
    }

    public void setWindowECondition(InspectionCondition windowECondition) {
        this.windowECondition = windowECondition;
    }

    public String getWindowERemarks() {
        return windowERemarks;
    }

    public void setWindowERemarks(String windowERemarks) {
        this.windowERemarks = windowERemarks;
    }

    public InspectionCondition getDoorECondition() {
        return doorECondition;
    }

    public void setDoorECondition(InspectionCondition doorECondition) {
        this.doorECondition = doorECondition;
    }

    public String getDoorERemarks() {
        return doorERemarks;
    }

    public void setDoorERemarks(String doorERemarks) {
        this.doorERemarks = doorERemarks;
    }

    public InspectionCondition getGutterCondition() {
        return gutterCondition;
    }

    public void setGutterCondition(InspectionCondition gutterCondition) {
        this.gutterCondition = gutterCondition;
    }

    public String getGutterRemarks() {
        return gutterRemarks;
    }

    public void setGutterRemarks(String gutterRemarks) {
        this.gutterRemarks = gutterRemarks;
    }

    public InspectionCondition getShutterCondition() {
        return shutterCondition;
    }

    public void setShutterCondition(InspectionCondition shutterCondition) {
        this.shutterCondition = shutterCondition;
    }

    public String getShutterRemarks() {
        return shutterRemarks;
    }

    public void setShutterRemarks(String shutterRemarks) {
        this.shutterRemarks = shutterRemarks;
    }

    public InspectionCondition getFloorCondition() {
        return floorCondition;
    }

    public void setFloorCondition(InspectionCondition floorCondition) {
        this.floorCondition = floorCondition;
    }

    public String getFloorRemarks() {
        return floorRemarks;
    }

    public void setFloorRemarks(String floorRemarks) {
        this.floorRemarks = floorRemarks;
    }

    public InspectionCondition getWallsICondition() {
        return wallsICondition;
    }

    public void setWallsICondition(InspectionCondition wallsICondition) {
        this.wallsICondition = wallsICondition;
    }

    public String getWallsIRemarks() {
        return wallsIRemarks;
    }

    public void setWallsIRemarks(String wallsIRemarks) {
        this.wallsIRemarks = wallsIRemarks;
    }

    public InspectionCondition getCeilingCondition() {
        return ceilingCondition;
    }

    public void setCeilingCondition(InspectionCondition ceilingCondition) {
        this.ceilingCondition = ceilingCondition;
    }

    public String getCeilingRemarks() {
        return ceilingRemarks;
    }

    public void setCeilingRemarks(String ceilingRemarks) {
        this.ceilingRemarks = ceilingRemarks;
    }

    public InspectionCondition getElectricICondition() {
        return electricICondition;
    }

    public void setElectricICondition(InspectionCondition electricICondition) {
        this.electricICondition = electricICondition;
    }

    public String getElectricIRemarks() {
        return electricIRemarks;
    }

    public void setElectricIRemarks(String electricIRemarks) {
        this.electricIRemarks = electricIRemarks;
    }

    public InspectionCondition getWindowICondition() {
        return windowICondition;
    }

    public void setWindowICondition(InspectionCondition windowICondition) {
        this.windowICondition = windowICondition;
    }

    public String getWindowIRemarks() {
        return windowIRemarks;
    }

    public void setWindowIRemarks(String windowIRemarks) {
        this.windowIRemarks = windowIRemarks;
    }

    public InspectionCondition getDoorICondition() {
        return doorICondition;
    }

    public void setDoorICondition(InspectionCondition doorICondition) {
        this.doorICondition = doorICondition;
    }

    public String getDoorIRemarks() {
        return doorIRemarks;
    }

    public void setDoorIRemarks(String doorIRemarks) {
        this.doorIRemarks = doorIRemarks;
    }

    public InspectionCondition getClosetCondition() {
        return closetCondition;
    }

    public void setClosetCondition(InspectionCondition closetCondition) {
        this.closetCondition = closetCondition;
    }

    public String getClosetRemarks() {
        return closetRemarks;
    }

    public void setClosetRemarks(String closetRemarks) {
        this.closetRemarks = closetRemarks;
    }

    public InspectionCondition getStoveCondition() {
        return stoveCondition;
    }

    public void setStoveCondition(InspectionCondition stoveCondition) {
        this.stoveCondition = stoveCondition;
    }

    public String getStoveRemarks() {
        return stoveRemarks;
    }

    public void setStoveRemarks(String stoveRemarks) {
        this.stoveRemarks = stoveRemarks;
    }

    public InspectionCondition getCoolCondition() {
        return coolCondition;
    }

    public void setCoolCondition(InspectionCondition coolCondition) {
        this.coolCondition = coolCondition;
    }

    public String getCoolRemarks() {
        return coolRemarks;
    }

    public void setCoolRemarks(String coolRemarks) {
        this.coolRemarks = coolRemarks;
    }

    public InspectionCondition getHeatCondition() {
        return heatCondition;
    }

    public void setHeatCondition(InspectionCondition heatCondition) {
        this.heatCondition = heatCondition;
    }

    public String getHeatRemarks() {
        return heatRemarks;
    }

    public void setHeatRemarks(String heatRemarks) {
        this.heatRemarks = heatRemarks;
    }

    public InspectionCondition getElectricCondition() {
        return electricCondition;
    }

    public void setElectricCondition(InspectionCondition electricCondition) {
        this.electricCondition = electricCondition;
    }

    public String getElectricRemarks() {
        return electricRemarks;
    }

    public void setElectricRemarks(String electricRemarks) {
        this.electricRemarks = electricRemarks;
    }

    public InspectionCondition getPlumbCondition() {
        return plumbCondition;
    }

    public void setPlumbCondition(InspectionCondition plumbCondition) {
        this.plumbCondition = plumbCondition;
    }

    public String getPlumbRemarks() {
        return plumbRemarks;
    }

    public void setPlumbRemarks(String plumbRemarks) {
        this.plumbRemarks = plumbRemarks;
    }

    public InspectionCondition getSecurityCondition() {
        return securityCondition;
    }

    public void setSecurityCondition(InspectionCondition securityCondition) {
        this.securityCondition = securityCondition;
    }

    public String getSecurityRemarks() {
        return securityRemarks;
    }

    public void setSecurityRemarks(String securityRemarks) {
        this.securityRemarks = securityRemarks;
    }

    public InspectionCondition getGarageCondition() {
        return garageCondition;
    }

    public void setGarageCondition(InspectionCondition garageCondition) {
        this.garageCondition = garageCondition;
    }

    public String getGarageRemarks() {
        return garageRemarks;
    }

    public void setGarageRemarks(String garageRemarks) {
        this.garageRemarks = garageRemarks;
    }

    public InspectionCondition getWaterCondition() {
        return waterCondition;
    }

    public void setWaterCondition(InspectionCondition waterCondition) {
        this.waterCondition = waterCondition;
    }

    public String getWaterRemarks() {
        return waterRemarks;
    }

    public void setWaterRemarks(String waterRemarks) {
        this.waterRemarks = waterRemarks;
    }

    public InspectionCondition getSprinklerCondition() {
        return sprinklerCondition;
    }

    public void setSprinklerCondition(InspectionCondition sprinklerCondition) {
        this.sprinklerCondition = sprinklerCondition;
    }

    public String getSprinklerRemarks() {
        return sprinklerRemarks;
    }

    public void setSprinklerRemarks(String sprinklerRemarks) {
        this.sprinklerRemarks = sprinklerRemarks;
    }

    public InspectionCondition getSoftenerCondition() {
        return softenerCondition;
    }

    public void setSoftenerCondition(InspectionCondition softenerCondition) {
        this.softenerCondition = softenerCondition;
    }

    public String getSoftenerRemarks() {
        return softenerRemarks;
    }

    public void setSoftenerRemarks(String softenerRemarks) {
        this.softenerRemarks = softenerRemarks;
    }

    public boolean isAgreeCheck() {
        return agreeCheck;
    }

    public void setAgreeCheck(boolean agreeCheck) {
        this.agreeCheck = agreeCheck;
    }

    public MoveInForm(Long id, String location, String inspectionDate, InspectionCondition foundationCondition, String foundationRemarks, InspectionCondition wallsECondition, String wallsERemarks, InspectionCondition roofCondition, String roofRemarks, InspectionCondition electricECondition, String electricERemarks, InspectionCondition windowECondition, String windowERemarks, InspectionCondition doorECondition, String doorERemarks, InspectionCondition gutterCondition, String gutterRemarks, InspectionCondition shutterCondition, String shutterRemarks, InspectionCondition floorCondition, String floorRemarks, InspectionCondition wallsICondition, String wallsIRemarks, InspectionCondition ceilingCondition, String ceilingRemarks, InspectionCondition electricICondition, String electricIRemarks, InspectionCondition windowICondition, String windowIRemarks, InspectionCondition doorICondition, String doorIRemarks, InspectionCondition closetCondition, String closetRemarks, InspectionCondition stoveCondition, String stoveRemarks, InspectionCondition coolCondition, String coolRemarks, InspectionCondition heatCondition, String heatRemarks, InspectionCondition electricCondition, String electricRemarks, InspectionCondition plumbCondition, String plumbRemarks, InspectionCondition securityCondition, String securityRemarks, InspectionCondition garageCondition, String garageRemarks, InspectionCondition waterCondition, String waterRemarks, InspectionCondition sprinklerCondition, String sprinklerRemarks, InspectionCondition softenerCondition, String softenerRemarks, boolean agreeCheck) {
        this.id = id;
        this.location = location;
        this.inspectionDate = inspectionDate;
        this.foundationCondition = foundationCondition;
        this.foundationRemarks = foundationRemarks;
        this.wallsECondition = wallsECondition;
        this.wallsERemarks = wallsERemarks;
        this.roofCondition = roofCondition;
        this.roofRemarks = roofRemarks;
        this.electricECondition = electricECondition;
        this.electricERemarks = electricERemarks;
        this.windowECondition = windowECondition;
        this.windowERemarks = windowERemarks;
        this.doorECondition = doorECondition;
        this.doorERemarks = doorERemarks;
        this.gutterCondition = gutterCondition;
        this.gutterRemarks = gutterRemarks;
        this.shutterCondition = shutterCondition;
        this.shutterRemarks = shutterRemarks;
        this.floorCondition = floorCondition;
        this.floorRemarks = floorRemarks;
        this.wallsICondition = wallsICondition;
        this.wallsIRemarks = wallsIRemarks;
        this.ceilingCondition = ceilingCondition;
        this.ceilingRemarks = ceilingRemarks;
        this.electricICondition = electricICondition;
        this.electricIRemarks = electricIRemarks;
        this.windowICondition = windowICondition;
        this.windowIRemarks = windowIRemarks;
        this.doorICondition = doorICondition;
        this.doorIRemarks = doorIRemarks;
        this.closetCondition = closetCondition;
        this.closetRemarks = closetRemarks;
        this.stoveCondition = stoveCondition;
        this.stoveRemarks = stoveRemarks;
        this.coolCondition = coolCondition;
        this.coolRemarks = coolRemarks;
        this.heatCondition = heatCondition;
        this.heatRemarks = heatRemarks;
        this.electricCondition = electricCondition;
        this.electricRemarks = electricRemarks;
        this.plumbCondition = plumbCondition;
        this.plumbRemarks = plumbRemarks;
        this.securityCondition = securityCondition;
        this.securityRemarks = securityRemarks;
        this.garageCondition = garageCondition;
        this.garageRemarks = garageRemarks;
        this.waterCondition = waterCondition;
        this.waterRemarks = waterRemarks;
        this.sprinklerCondition = sprinklerCondition;
        this.sprinklerRemarks = sprinklerRemarks;
        this.softenerCondition = softenerCondition;
        this.softenerRemarks = softenerRemarks;
        this.agreeCheck = agreeCheck;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false, columnDefinition ="Date")
    private String inspectionDate;

    @Enumerated
    @Column
    private InspectionCondition foundationCondition;

    @Column
    private String foundationRemarks;

    @Enumerated
    @Column
    private InspectionCondition wallsECondition;

    @Column
    private String wallsERemarks;
    @Enumerated
    @Column
    private InspectionCondition roofCondition;

    @Column
    private String roofRemarks;
    @Enumerated
    @Column
    private InspectionCondition electricECondition;

    @Column
    private String electricERemarks;
    @Enumerated
    @Column
    private InspectionCondition windowECondition;

    @Column
    private String windowERemarks;
    @Enumerated
    @Column
    private InspectionCondition doorECondition;

    @Column
    private String doorERemarks;
    @Enumerated
    @Column
    private InspectionCondition gutterCondition;

    @Column
    private String gutterRemarks;
    @Enumerated
    @Column
    private InspectionCondition shutterCondition;

    @Column
    private String shutterRemarks;
    @Enumerated
    @Column
    private InspectionCondition floorCondition;

    @Column
    private String floorRemarks;
    @Enumerated
    @Column
    private InspectionCondition wallsICondition;

    @Column
    private String wallsIRemarks;
    @Enumerated
    @Column
    private InspectionCondition ceilingCondition;

    @Column
    private String ceilingRemarks;
    @Enumerated
    @Column
    private InspectionCondition electricICondition;

    @Column
    private String electricIRemarks;
    @Enumerated
    @Column
    private InspectionCondition windowICondition;

    @Column
    private String windowIRemarks;
    @Enumerated
    @Column
    private InspectionCondition doorICondition;

    @Column
    private String doorIRemarks;
    @Enumerated
    @Column
    private InspectionCondition closetCondition;

    @Column
    private String closetRemarks;
    @Enumerated
    @Column
    private InspectionCondition stoveCondition;

    @Column
    private String stoveRemarks;
    @Enumerated
    @Column
    private InspectionCondition coolCondition;

    @Column
    private String coolRemarks;
    @Enumerated
    @Column
    private InspectionCondition heatCondition;

    @Column
    private String heatRemarks;
    @Enumerated
    @Column
    private InspectionCondition electricCondition;

    @Column
    private String electricRemarks;
    @Enumerated
    @Column
    private InspectionCondition plumbCondition;

    @Column
    private String plumbRemarks;
    @Enumerated
    @Column
    private InspectionCondition securityCondition;

    @Column
    private String securityRemarks;
    @Enumerated
    @Column
    private InspectionCondition garageCondition;

    @Column
    private String garageRemarks;
    @Enumerated
    @Column
    private InspectionCondition waterCondition;

    @Column
    private String waterRemarks;
    @Enumerated
    @Column
    private InspectionCondition sprinklerCondition;

    @Column
    private String sprinklerRemarks;
    @Enumerated
    @Column
    private InspectionCondition softenerCondition;

    @Column
    private String softenerRemarks;
    @Column(nullable = false)
    private boolean agreeCheck;



    public enum InspectionCondition {
        GOOD_CONDITION,
        NEEDS_ATTENTION,
        NOT_APPLICABLE
    }
}
