package tarea.pkg3.de.analisis;

public class Isla 
{
    private int _Canibales;
    private int _Misioneros;
    
    public Isla(int pCanibales, int pMisioneros)
    {
        this._Canibales = pCanibales;
        this._Misioneros = pMisioneros;
    }

    public int getCanibales() {
        return _Canibales;
    }

    public void setCanibales(int _Canibales) {
        this._Canibales = _Canibales;
    }

    public int getMisioneros() {
        return _Misioneros;
    }

    public void setMisioneros(int _Misioneros) {
        this._Misioneros = _Misioneros;
    }
}
