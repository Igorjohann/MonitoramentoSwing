
package testeoshimemoria;

import oshi.*;
import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

public class Memoria {
    
    
    private static SystemInfo systemInfo = new SystemInfo();
    
    
    public static GlobalMemory getObjetoMemoria() {
        return systemInfo.getHardware().getMemory();
    }
    
     public static String getMemoriaTotal(){
        return FormatUtil.formatBytes(getObjetoMemoria().getTotal());
    }
    
    public static String getMemoriaUtilizada(){
        getObjetoMemoria().updateAttributes();
        return FormatUtil.formatBytes(getObjetoMemoria().getTotal() - getObjetoMemoria().getAvailable());
    }
            
    public static String getPorcentagemDeUso() {
       double singleDouble = ((double)(getObjetoMemoria().getTotal() - getObjetoMemoria().getAvailable()) / (double)getObjetoMemoria().getTotal()) * 100.0;
        return String.format("%.2f%%", singleDouble);
    }
    
}
