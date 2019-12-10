package com.Mercado.ListaNormal;

public class LSCircular extends LSimple {
    LSCircular(){super();}
    public boolean esVacia(){return (super.esVacia());}
    NodoS getCaabecera(){return p;}
    void setCabecera(NodoS q){p=q;}
    @Override
    int nElem() {
        NodoS x;int c=0;
        if (!esVacia()) {
            x=p;c=1;
            while(x.getSig()!=p){c++;x=x.getSig();}         
        }return c;
    }

    @Override
    void adiFin(Object Dato) {
        NodoS au,u;NodoS z=new NodoS();z.setDato(Dato);
        if (esVacia()) {
            z.setSig(z);p=z;
        }
        else{
            u=p;
            while(u.getSig()!=p){u=u.getSig();u.setSig(z);z.setSig(p);}
        }
       
    }

    @Override
    void adiPrimero(Object Dato) {
        NodoS z,u,au=null;z=new NodoS();z.setDato(Dato);
        if (esVacia()) {
            z.setSig(z);
        }else{
            z.setSig(p);u=p;
            while(u.getSig()!=p){au=u;u=u.getSig();}u.setSig(z);
        }p=z;
    }

    @Override
    void adiDespuesKNodo(int k, Object Dato) {
        int cont = 0,sw = 0;
        NodoS q,z;
        q = p;
        while (sw ==0){
            cont++;
            if (cont==k){
                z = new NodoS();
                z.setDato(Dato);
                z.setSig(q.getSig());
                q.setSig(z);
                sw = 1;
            } else {
                q = q.getSig();
            }
        }
    }

    @Override
    void adiAntesKNodo(int k, Object Dato) {
        if (k==1)
            adiPrimero(Dato);
        else
            adiDespuesKNodo((k-1),Dato);
    }

    @Override
    Object eliFin() {
        NodoS u,au=null;
        Object da=null;
        if (!esVacia()) {
            u=p;
            while(u.getSig()!=p){
                au=u;u=u.getSig();
            }da=u.getDato();
            if(u==p)p=null;
            else au.setSig(p);
        }
        else System.out.println("Lista Vacia");
        return da;
    }

    @Override
    Object eliPrimero() {
        NodoS u,ap=null;Object da=null;
        if(!esVacia()){
            da=p.getDato();u=p;
            while(u.getSig()!=p){
                u=u.getSig();
            }
            if(u==p)p=null;
            else{
                ap=p;p=p.getSig();ap.setDato(null);u.setSig(p);ap=null;
            }
            }
        else System.out.println("Lista Vacia");
        return da;
    }

    @Override
    Object eliKesiNodo(int k) {
        int cont; Object da = null;NodoS q,aq=null;
        if (esVacia())
            System.out.println("Lista vacia");
        else {
            if (k == 1){
                da = eliPrimero();
            } else {
                q = p;
                cont = 1;
                while (k != cont){
                    cont++;
                    aq = q;
                    q = q.getSig();
                }
                da =q.getDato();
                aq.setSig(q.getSig());
            }
        }
        return da;
    }

    @Override
    void mostrar() {
        NodoS x;
        if (!esVacia()) {
            x=p;
            while(x.getSig()!=p){
                System.out.println("\t"+x.getDato());
                x=x.getSig();
            }
            System.out.println("\t"+x.getDato());    
        }
        else System.out.println("Lista Vacia");       
    }
    
    int nVeces(Object d){
        int c=1,n;Object dato;n=nElem();
        for (int j = 0; j < n; j++) {
            dato=eliPrimero();adiFin(dato);if(d.equals(dato)){c++;}
        }
        return c;
    }
}
