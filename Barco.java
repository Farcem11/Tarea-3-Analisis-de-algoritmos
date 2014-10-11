package tarea.pkg3.de.analisis;

public class Barco 
{
    private boolean _Posicion;
    
    public Barco(boolean pPosicion)
    {
        this._Posicion = pPosicion;
    }

    public String getPosicion() {
        if(this.isPosicion()) 
            return "I";
        else 
            return "D";
    }

    public boolean Mover() {
        return !this.isPosicion();
    }

    public boolean isPosicion() {
        return _Posicion;
    }

    public void setPosicion(boolean _Posicion) {
        this._Posicion = _Posicion;
    }
}
