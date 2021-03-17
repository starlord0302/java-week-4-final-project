package map;

public class Field {

  private FieldType fieldType;

  public Field(FieldType fieldType) {
    this.fieldType = fieldType;
  }

  public FieldType getFieldType() {
    return this.fieldType;
  }

  public void printField(boolean showField) {
    if (showField) {
      System.out.print("[" + this.fieldType.name().charAt(0) + "]");
    } else {
      System.out.print("[ ]");
    }

  }
}