import java.io.*;
import java.util.*;
class Record implements Serializable{

public int DeviceId;
public String ArrivalTime;
public String DepartureTime;

public void writeObject(ObjectOutputStream oos) throws IOException{
	oos.writeObject(DeviceId);
	oos.writeObject(ArrivalTime);
	oos.writeObject(DepartureTime);	
}

}
class DBHeap implements Serializable{

public int numberofRecords;// = 5000000;
public List<Record> records = new ArrayList<Record>();
    private static final long serialVersionUID = 1L;
	public DBHeap(){
	numberofRecords = 5000000;
}

public void writeObject(ObjectOutputStream oos) throws IOException{
oos.writeObject(numberofRecords);
for(int i = 0; i < numberofRecords; i++){
	records.get(i).writeObject(oos);
}
}
public static void main( String[] args ) throws FileNotFoundException, IOException{
	DBHeap myHeap = new DBHeap();
	Record row1 = new Record();
	row1.DeviceId = 999;
	row1.ArrivalTime = "2 seconds ago";
	myHeap.records.add( row1 );
	myHeap.records.add( row1);
	File f = new File("heap.pagesize");
	ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(f) );
	oos.writeObject(myHeap);
	oos.close();
	

}



}
