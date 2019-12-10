package com.Mercado.ListaNormal;

public class LSNormal extends LSimple {

    public LSNormal(){
        super();
    }

    public boolean esVacia(){
        return super.esVacia();
    }

    public NodoS getCabecera(){
        return p;
    }

    public void setCabecera(NodoS q){
        p = q;
    }

    @Override
    public int nElem() {
        NodoS x; int cont;
        if (esVacia()){
            cont = 0;
        } else {
            x = p;
            cont = 1;
            while(x.getSig() != null){
                cont++;
                x = x.getSig();
            }
        }
        return cont;
    }

    @Override
    public void adiFin(Object Dato) {
        NodoS z,u;
        z = new NodoS();
        z.setDato(Dato);
        if (esVacia()){
            p = z;
        } else {
            u = p;
            while (u.getSig() != null){
                u = u.getSig();
            }
            u.setSig(z);
        }
    }

    @Override
    public void adiPrimero(Object Dato) {
        NodoS z,u;
        z = new NodoS();
        z.setDato(Dato);
        z.setSig(p);
        p = z;
    }

    @Override
    public void adiDespuesKNodo(int k, Object Dato) //validar k primero
    {
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
    public void adiAntesKNodo(int k, Object Dato) {
        if (k==1)
            adiPrimero(Dato);
        else
            adiDespuesKNodo((k-1),Dato);
    }

    @Override
    public Object eliFin() {
        NodoS u,au=null;Object da = null;
        if (!esVacia()){
            u = p;
            while (u.getSig() != null){
                au = u;
                u = u.getSig();
            }
            da = u.getDato();
            if (u == p){
                p = null;
            } else au.setSig(null);
        } else {
            System.out.println("Lista vacia");
        }
        return da;
    }

    @Override
    public Object eliPrimero() {
        Object da = null;
        if (!esVacia()){
            da = p.getDato();
            p = p.getSig();
        } else {
            System.out.println("Lista vacia");
        }
        return da;
    }

    @Override
    public Object eliKesiNodo(int k) {
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
    public void mostrar() {
        if (!esVacia()){
            NodoS x = p;
            while (x != null){
                System.out.println("\t"+x.getDato());
                x = x.getSig();
            }
        } else {
            System.out.println("Lista vacia");
        }
    }
}
