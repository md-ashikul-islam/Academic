
package hospital;


public class WRM{
    Object []data;
    int start;
    int size;
    int id;
    
    
    public WRM(){
    data=new Object[15];
    start =0;
    size=0;
    id=100;
    }
    
    public void RegisterPatient(Patient p){
       if(size==data.length){
           System.out.println("Not Successful!");
       }
       else{
           p.id=id;
           id++;
           data[(start+size)%data.length]=p;
           size++;
           System.out.println("Success");
       }
    }
    
    public Patient ServePatient(){
        if(size==0){
            System.out.println("No more patient today");
            return null;
        }
        else{
         Patient P=(Patient)data[start];
            data[start]=null;
           start=(start+1)%data.length;
           size--;
            System.out.println("Name of Patient Being Served :"+P.Name);
           return P;
        }
    }
    
    public void showAllPatient() {
        int strt = start;
        for (int i = 0; i < data.length; i++) {

            for (int j = 1; j < data.length; j++) {

                if (data[strt] != null && data[(strt + j) % data.length] != null) {
                    Patient p = (Patient) data[strt];
                    Patient p2 = (Patient) data[(strt + j) % data.length];

                    if (p2.Name.compareTo(p.Name) > 0) {
                        Patient temp = (Patient) data[strt];
                        data[strt] = data[(strt + j) % data.length];
                        data[(strt + j) % data.length] = temp;
                    }
                }
            }
            strt = (strt + 1) % data.length;
        }
        int s = start;
        for (int i = 0; i < data.length; i++) {
            if (data[s] != null) {
                Patient p = (Patient) data[s];
                System.out.println(p.Name +"----"+p.age+"----"+ p.BloodGroup+"----"+p.id);
                s = (s + 1) % data.length;

            } else {
                s = (s + 1) % data.length;
            }
        }
    }


    public boolean CanDoctorGoHome(){
        if(size==0){
            System.out.println("YES");
            return true;
        }
        else{
            System.out.println("NO");
            return false;
        }
    }
    public void CancelAll(){
        for(int i=0;i<size+2;i++){
            Patient P=(Patient)data[start];
            data[start]=null;
           start=(start+1)%data.length;
           size--;
        }
        if(size==0){
            System.out.println("Success");
        }
        else{
            System.out.println("Failed");
        }
    }
}
