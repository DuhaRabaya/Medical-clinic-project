import java.util.*;
import java.lang.*;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyArrayList<Patient> patients = new MyArrayList();
        MyQueue<Patient> Appointments=new MyQueue<>();
        int f = 0, i = 0;
        while (f != 1) {
            System.out.println("add patient's information in this order :");
            System.out.println("name , age , Symptoms  , id");
            patients.add(new Patient(in.next(), in.nextInt(),in.next(), in.nextInt()));
            if (patients.size == 0) break;
            else {
            Examinations(patients.get(i),Appointments);
            if (i>0) {
                if (!(checkid(patients.get(i), patients, Appointments))) {
                    patients.get(i).medicalhestory.push(patients.get(i).getIllness());

                } else {
                    i--;
                }
            }
            else  patients.get(i).medicalhestory.push(patients.get(i).getIllness());

                i++;

                System.out.println("enter 0 if you want to add another patient , 1 if not");
                f = in.nextInt();
            }
        }

        System.out.println("The patients: ");

            for (int j = 0; j < patients.size; j++) {
                System.out.println(j+1 + " : ");
                patients.get(j).PrintInfo();
                System.out.println();
            }

        System.out.println("the appointments scedule : ");

        for (int j=0 ; j < Appointments.size ; j++) {
            System.out.println(j+1 + " : " + Appointments.get(j).getName());
       }
        System.out.println("do you want to display any patient's medical hestory ?" +
                "if yes enter the id of the patient if no enter -1");

        int y=in.nextInt();
        if(y!=-1)
        {
            for(int k=0 ; k<patients.size ; k++)
            {
                if(y == patients.get(k).getId()) {
                    System.out.println("the patient is : " +" " + patients.get(k).getName() + " the medical hestory is :");
                    System.out.println(patients.get(k).medicalhestory.toString());
                    break;
                }
            }
        }

        }

    public static  void Examinations(Patient p ,  MyQueue<Patient> Appointments){
        Scanner in=new Scanner(System.in);
        System.out.println("enter the patient's tempreture :");
        p.setTempreture(in.nextInt());
        System.out.println("enter heartbeats per minuet :");
        p.setPuls(in.nextInt());

        if(p.getTempreture()>= 39 || p.getTempreture()<=20 || p.getPuls()>100 || p.getPuls()<70)
        {
          Appointments.addbyindex(p , 0);
        }
        else {
            Appointments.enqueue(p);
        }
    }
    public static  boolean checkid(Patient p , MyArrayList<Patient> parr , MyQueue<Patient> ap) {
      int j=-1;
        for(int i=0 ; i<parr.size-1 ; i++)
        {
            if(p.getId() == parr.get(i).getId())
               j=i;
        }

       if(j<0 || j> parr.size) return false;
        Stack med=parr.get(j).medicalhestory;
        parr.get(parr.size-1).medicalhestory.push(med.toString());
        parr.get(parr.size-1).medicalhestory.push(p.getIllness());
        deleteexistingpatient(parr.get(j).getId() ,ap);
        parr.removebyindex(j);
       return true;
    }
    public static void deleteexistingpatient(int id , MyQueue<Patient> ap)
    {
        int j=-1;
        for(int i=0 ; i<ap.size-1 ; i++)
        {
            if(id == ap.get(i).getId())
                j=i;
        }
      ap.deletebyindex(j);
    }
}