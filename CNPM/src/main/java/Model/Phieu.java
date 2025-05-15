package Model;
import java.util.List;
import java.util.Objects;
import java.time.LocalDateTime;

public class Phieu {
	
	private int ID;
	private int ID_Partner;
	private int ID_Employee;
	private LoaiPhieu Type;
	private LocalDateTime DateTime;

	public Phieu(int iD, int iD_Partner, int iD_Employee, LoaiPhieu type, LocalDateTime dateTime) {
		super();
		ID = iD;
		ID_Partner = iD_Partner;
		ID_Employee = iD_Employee;
		Type = type;
		DateTime = dateTime;

	}
	public Phieu() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getID_Partner() {
		return ID_Partner;
	}
	public void setID_Partner(int iD_Partner) {
		ID_Partner = iD_Partner;
	}
	public int getID_Employee() {
		return ID_Employee;
	}
	public void setID_Employee(int iD_Employee) {
		ID_Employee = iD_Employee;
	}
	public LoaiPhieu getType() {
		return Type;
	}
	public void setType(LoaiPhieu type) {
		Type = type;
	}
	public LocalDateTime getDateTime() {
		return DateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		DateTime = dateTime;
	}
	public String getTypeDescription() {
	    return (Type != null) ? Type.getDescription() : "";
	}

	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phieu)) return false;
        Phieu phieu = (Phieu) o;
        return ID == phieu.ID &&
                ID_Partner == phieu.ID_Partner &&
                ID_Employee == phieu.ID_Employee &&
                Type == phieu.Type &&
                Objects.equals(DateTime, phieu.DateTime);
    }

    @Override
    public int hashCode() {
    	return Objects.hash(ID, ID_Partner, ID_Employee, Type, DateTime);
    }
    
    public java.util.Date getDateTimeAsDate() {
        return java.util.Date.from(this.DateTime.atZone(java.time.ZoneId.systemDefault()).toInstant());
    }

}
