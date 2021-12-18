package btx.prog.one.measurement.converter;

import btx.prog.one.measurement.unit.Unit;

import java.util.HashSet;
import java.util.Set;

public class ConverterSupplier {
    public static Set<Converter> converters = new HashSet<>();

    public static boolean put(Converter converter){
        if (converters.contains(converter)){
            return false;
        }
        converters.add(converter);
        return true;
    }

    public static Converter get(Unit sourceUnit,Unit targetUnit){
        for (Converter converter:converters){
            if (converter.getSourceUnit().equals(sourceUnit)&& converter.getTargetUnit().equals(targetUnit)){
                return converter;
            }
        }
        return null;
    }

    public static Converter get(Converter converter){
        for(Converter conv:converters){
            if (conv.getSourceUnit().equals(converter.getSourceUnit())&& conv.getTargetUnit().equals(converter.getTargetUnit())){
                return conv;
            }
        }
        return null;
    }

    public static void clear(){
        converters.clear();
    }
}
