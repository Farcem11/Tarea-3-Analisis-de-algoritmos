package tarea.pkg3.de.analisis;

import java.util.ArrayList;

public class Estado 
{
    private Isla _IslaDerecha;
    private Isla _IslaIzquierda;
    private Barco _Barco;
    
    static ArrayList<Estado> _EstadosVisitados = new ArrayList<>();
    public Estado(){}
    
    public void Mostrar()
    {
        System.out.println("II(C:" + this._IslaIzquierda.getCanibales() + " M:" + this._IslaIzquierda.getMisioneros() + ") " + 
                           "ID(C:" + this._IslaDerecha.getCanibales() + " M:" + this._IslaDerecha.getMisioneros() + ") " +
                           "B:" + this._Barco.getPosicion());
    }

    static boolean MismosEstados(Estado E1, Estado E2)
    {
        return
        (E1.getBarco().getPosicion().equals(E2.getBarco().getPosicion()) &&
                
         E1.getIslaDerecha().getCanibales() == E2.getIslaDerecha().getCanibales() &&
         E1.getIslaDerecha().getMisioneros() == E2.getIslaDerecha().getMisioneros() &&

         E1.getIslaIzquierda().getCanibales() == E2.getIslaIzquierda().getCanibales() &&
         E1.getIslaIzquierda().getMisioneros() == E1.getIslaIzquierda().getMisioneros());
    }
    
    public boolean EstadoYaVisitado(Estado pEstado)
    {
        boolean Encontrado = false;
        for(int i = 0; i < _EstadosVisitados.size() && !Encontrado; i++)
        {
            if(MismosEstados(pEstado,_EstadosVisitados.get(i)))
            {
                Encontrado = true;
            }
        }
        return Encontrado;
    }
    
    public ArrayList<Estado> CrearPosiblesSoluciones()
    {
        this.Mostrar();
        System.out.println("Estado marcado como visitado\n");
        _EstadosVisitados.add(this);
        ArrayList<Estado> Soluciones = new ArrayList<>();
        if(!this._Barco.isPosicion())
        {
            if(this._IslaIzquierda.getCanibales() - 2 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales() - 2, this._IslaIzquierda.getMisioneros());
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales() + 2, this._IslaDerecha.getMisioneros());
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }
            
            if(this._IslaIzquierda.getCanibales() - 1 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales() - 1, this._IslaIzquierda.getMisioneros());
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales() + 1, this._IslaDerecha.getMisioneros());
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }
         
            if(this._IslaIzquierda.getMisioneros() - 2 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales(), this._IslaIzquierda.getMisioneros() - 2);
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales(), this._IslaDerecha.getMisioneros() + 2);
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }

            if(this._IslaIzquierda.getMisioneros() - 1 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales(), this._IslaIzquierda.getMisioneros() - 1);
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales(), this._IslaDerecha.getMisioneros() + 1);
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }         
            
            if(this._IslaIzquierda.getCanibales() - 1 >= 0 && this._IslaIzquierda.getMisioneros() - 1 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales() - 1, this._IslaIzquierda.getMisioneros() - 1);
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales() + 1, this._IslaDerecha.getMisioneros() + 1);
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }
        }
        else
        {
            if(this._IslaDerecha.getCanibales() - 2 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales() + 2, this._IslaIzquierda.getMisioneros());
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales() - 2, this._IslaDerecha.getMisioneros());
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }
            
            if(this._IslaDerecha.getCanibales() - 1 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales() + 1, this._IslaIzquierda.getMisioneros());
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales() - 1, this._IslaDerecha.getMisioneros());
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }
         
            if(this._IslaDerecha.getMisioneros() - 2 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales(), this._IslaIzquierda.getMisioneros() + 2);
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales(), this._IslaDerecha.getMisioneros() - 2);
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }

            if(this._IslaDerecha.getMisioneros() - 1 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales(), this._IslaIzquierda.getMisioneros() + 1);
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales(), this._IslaDerecha.getMisioneros() - 1);
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }         
            
            if(this._IslaDerecha.getCanibales() - 1 >= 0 && this._IslaDerecha.getMisioneros() - 1 >= 0)
            {
                Estado NewEstado = new Estado();
                NewEstado._Barco = new Barco(this._Barco.Mover());
                NewEstado._IslaIzquierda = new Isla(this._IslaIzquierda.getCanibales() + 1, this._IslaIzquierda.getMisioneros() + 1);
                NewEstado._IslaDerecha = new Isla(this._IslaDerecha.getCanibales() - 1, this._IslaDerecha.getMisioneros() - 1);
                if(!EstadoYaVisitado(NewEstado))
                    Soluciones.add(NewEstado);
            }
        }
        return Soluciones;
    }
    
    public Isla getIslaDerecha() {
        return _IslaDerecha;
    }

    public void setIslaDerecha(Isla _IslaDerecha) {
        this._IslaDerecha = _IslaDerecha;
    }

    public Isla getIslaIzquierda() {
        return _IslaIzquierda;
    }

    public void setIslaIzquierda(Isla _IslaIzquierda) {
        this._IslaIzquierda = _IslaIzquierda;
    }

    public Barco getBarco() {
        return _Barco;
    }

    public void setBarco(Barco _Barco) {
        this._Barco = _Barco;
    }
}