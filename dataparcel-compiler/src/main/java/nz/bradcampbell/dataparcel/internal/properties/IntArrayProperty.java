package nz.bradcampbell.dataparcel.internal.properties;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.ParameterSpec;
import nz.bradcampbell.dataparcel.internal.Property;

import javax.lang.model.element.VariableElement;

import static nz.bradcampbell.dataparcel.DataParcelProcessor.DATA_VARIABLE_NAME;

public class IntArrayProperty extends Property {
  public IntArrayProperty(boolean isNullable, String name, VariableElement variableElement) {
    super(isNullable, name, variableElement);
  }

  @Override protected void readFromParcelInner(CodeBlock.Builder block, ParameterSpec in) {
    block.add("$N.createIntArray()", in);
  }

  @Override protected void writeToParcelInner(CodeBlock.Builder block, ParameterSpec dest) {
    block.add("$N.writeIntArray($N.$N())", dest, DATA_VARIABLE_NAME, getName());
  }
}