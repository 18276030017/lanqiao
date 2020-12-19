import java.util.List;

public class Kehu {
    String KehuID;
    String KehuName;
    String address;
    String phone;

    DingDan dingdan;

    List<DingDan> selectedDingDan;

    public String getKehuID() {
        return KehuID;
    }

    public void setKehuID(String kehuID) {
        KehuID = kehuID;
    }

    public String getKehuName() {
        return KehuName;
    }

    public void setKehuName(String kehuName) {
        KehuName = kehuName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DingDan getDingdan() {
        return dingdan;
    }

    public void setDingdan(DingDan dingdan) {
        this.dingdan = dingdan;
    }

    public List<DingDan> getSelectedDingDan() {
        return selectedDingDan;
    }

    public void setSelectedDingDan(List<DingDan> selectedDingDan) {
        this.selectedDingDan = selectedDingDan;
    }
}
