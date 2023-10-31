package Controller;

import Model.Alumno;
import Model.Notas;

public class PensionController {
	public double calcularPension(String categoria, String semestre, double nota) {

	        double pensionInicial = 0.0;

	        switch (categoria) {
	            case "A":
	            	pensionInicial = 550.0;
	                break;

	            case "B":
	            	pensionInicial = 500.0;
	                break;
	            case "C":
	            	pensionInicial = 460.0;
	                break;
	            case "D":
	            	pensionInicial = 400.0;
	                break;

	            default:
	                return 0.0;
	        }

	        double descuento = 0.0;
	        if (nota >= 14 && nota <= 15) {
	            descuento = 0.10;
	        } else if (nota >= 16 && nota <= 17) {
	            descuento = 0.12;
	        } else if (nota >= 18 && nota <= 20) {
	            descuento = 0.15;
	        }
	        
	        double pensionFinal = pensionInicial - (pensionInicial * descuento);

	        return pensionFinal;
	    }
	
	public String obtenerPorcentajeDescuento(double promedio) {
        String porcentaje= "0";

        if (promedio >= 14 && promedio <= 15) {
            porcentaje = "10%";
        } else if (promedio >= 16 && promedio <= 17) {
            porcentaje = "12%";
        } else if (promedio >= 18 && promedio <= 20) {
            porcentaje = "15%";
        }

        return porcentaje;
    }
	
	public String obtenerPensionCategoria(String categoria) {
		String pensionInicial = "0";
		
        switch (categoria) {
        case "A":
        	pensionInicial = "550.0";
            break;

        case "B":
        	pensionInicial = "500.0";
            break;
        case "C":
        	pensionInicial = "460.0";
            break;
        case "D":
        	pensionInicial = "400.0";
            break;

        default:
            return "0.0";
    }
        return pensionInicial;

	}
}
