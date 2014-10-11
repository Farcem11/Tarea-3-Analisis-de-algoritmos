package tarea.pkg3.de.analisis;
import java.util.ArrayList;
import static tarea.pkg3.de.analisis.Estado.MismosEstados;
import static tarea.pkg3.de.analisis.Estado._EstadosVisitados;

public class Juego 
{
    private boolean _Resuelto;
    private final Estado _EstadoFinal;
    private final Estado _EstadoInicial;
    
    public Juego(int pCanibales, int pMisioneros)
    {   
        this._Resuelto = false;
        
        this._EstadoInicial = new Estado();
        this._EstadoInicial.setIslaIzquierda(new Isla(pCanibales, pMisioneros));
        this._EstadoInicial.setIslaDerecha(new Isla(0,0));
        this._EstadoInicial.setBarco(new Barco(false));
        
        this._EstadoFinal = new Estado();
        this._EstadoFinal.setIslaIzquierda(new Isla(0,0));
        this._EstadoFinal.setIslaDerecha(new Isla(pCanibales, pMisioneros));
        this._EstadoFinal.setBarco(new Barco(true));
    }
    
    static void MostrarEstados(ArrayList<Estado> pArrayEstados)
    {
        for(Estado estado: pArrayEstados)
        {
            estado.Mostrar();
        }
    }
    
    boolean ValidarEstado(Estado pEstado)
    {
        if((pEstado.getIslaDerecha().getCanibales() > pEstado.getIslaDerecha().getMisioneros() && pEstado.getIslaDerecha().getMisioneros() != 0)||
           (pEstado.getIslaIzquierda().getCanibales() > pEstado.getIslaIzquierda().getMisioneros() && pEstado.getIslaIzquierda().getMisioneros() != 0))
        {
           return false; 
        }
        else
        {
            return true;
        }
    }
    
    void BackTracking(Estado pEstadoActual)
    {
        if(ValidarEstado(pEstadoActual))
        {
            if(!this._Resuelto && MismosEstados(pEstadoActual, this._EstadoFinal))
            {
                _EstadosVisitados.add(pEstadoActual);
                pEstadoActual.Mostrar();
                System.out.println("Es una solucion\n");
                this._Resuelto = true;
            }
            else
            {
                pEstadoActual.Mostrar();
                System.out.println("No es una solucion\n");
                if(!this._Resuelto)
                {
                    ArrayList<Estado> PosiblesSoluciones = pEstadoActual.CrearPosiblesSoluciones();
                    System.out.println("Nuevas posibles soluciones:");
                    MostrarEstados(PosiblesSoluciones);
                    System.out.println("Fin de las soluciones\n");
                    
                    if(!PosiblesSoluciones.isEmpty())
                    {
                        for(int i = 0; i < PosiblesSoluciones.size() && !this._Resuelto; i++)
                        {
                            BackTracking(PosiblesSoluciones.get(i));
                        }
                    }
                }
            }
        }
        else
        {
            pEstadoActual.Mostrar();
            System.out.println("Se devuelve en las soluciones ya que los canibales son mas que los misioneros\n");
        }
    }
    
    public static void main(String[] args) 
    {
        int CantidadDeCanibales = 3;
        int CantidadDeMisioneros = 3;
        
        Juego juego = new Juego(CantidadDeCanibales, CantidadDeMisioneros);
        juego.BackTracking(juego._EstadoInicial);
        
        System.out.println("Camino de soluciones creado con el backtraking:");
        MostrarEstados(_EstadosVisitados);
    }
}
