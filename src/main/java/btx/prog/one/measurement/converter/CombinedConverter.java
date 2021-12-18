package btx.prog.one.measurement.converter;

import btx.prog.one.measurement.unit.Unit;
import btx.prog.one.rationalnumber.RationalNumber;

public class CombinedConverter extends Converter{

    private Converter converter1;
    private Converter converter2;

    public CombinedConverter(Converter converter1, Converter converter2) {
        super(converter1.getSourceUnit(), converter2.getTargetUnit());
        if(!converter1.getTargetUnit().equals(converter2.getSourceUnit()))
        {throw new IllegalArgumentException("Incompatible converters");}
        this.converter1 = converter1;
        this.converter2 = converter2;
    }

    @Override
    protected RationalNumber convertValue(RationalNumber value) {
        return this.converter2.convertValue(this.converter1.convertValue(value));
    }
}
