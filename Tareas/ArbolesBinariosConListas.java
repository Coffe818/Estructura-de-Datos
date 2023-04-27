package Tareas;

import java.util.LinkedList;

public class ArbolesBinariosConListas {
    //esta clase es para el arbol
    public class NODOB{
        int NumEmp;
        String NomEmp;
        float Sueldo;
        NODOB LCHILD;
        NODOB RCHILD;

        public NODOB(int NumEmp, String NomEmp, float Sueldo) {
            this.NumEmp = NumEmp;
            this.NomEmp = NomEmp;
            this.Sueldo = Sueldo;
            this.LCHILD = null;
            this.RCHILD = null;
        }//end constructor
    }//end class NODOB

    //esta clase es para la lista
    LinkedList <Integer> cola = new LinkedList<Integer>();
    public class NODOL{
        int NumEmp;
        String NomEmp;
        float Sueldo;
        NODOL Next;

        public NODOL(int NumEmp, String NomEmp, float Sueldo) {
            this.NumEmp = NumEmp;
            this.NomEmp = NomEmp;
            this.Sueldo = Sueldo;
        }//end constructor
    }//end class NODOB
    
}// end class
