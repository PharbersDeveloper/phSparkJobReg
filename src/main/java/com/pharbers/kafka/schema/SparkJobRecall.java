/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pharbers.kafka.schema;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SparkJobRecall extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -187988831825255062L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SparkJobRecall\",\"namespace\":\"com.pharbers.kafka.schema\",\"fields\":[{\"name\":\"header\",\"type\":{\"type\":\"record\",\"name\":\"Header\",\"fields\":[{\"name\":\"channel\",\"type\":\"string\"}]}},{\"name\":\"payload\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public com.pharbers.kafka.schema.Header header;
  @Deprecated public java.lang.CharSequence payload;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SparkJobRecall() {}

  /**
   * All-args constructor.
   * @param header The new value for header
   * @param payload The new value for payload
   */
  public SparkJobRecall(com.pharbers.kafka.schema.Header header, java.lang.CharSequence payload) {
    this.header = header;
    this.payload = payload;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return header;
    case 1: return payload;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: header = (com.pharbers.kafka.schema.Header)value$; break;
    case 1: payload = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'header' field.
   * @return The value of the 'header' field.
   */
  public com.pharbers.kafka.schema.Header getHeader() {
    return header;
  }

  /**
   * Sets the value of the 'header' field.
   * @param value the value to set.
   */
  public void setHeader(com.pharbers.kafka.schema.Header value) {
    this.header = value;
  }

  /**
   * Gets the value of the 'payload' field.
   * @return The value of the 'payload' field.
   */
  public java.lang.CharSequence getPayload() {
    return payload;
  }

  /**
   * Sets the value of the 'payload' field.
   * @param value the value to set.
   */
  public void setPayload(java.lang.CharSequence value) {
    this.payload = value;
  }

  /**
   * Creates a new SparkJobRecall RecordBuilder.
   * @return A new SparkJobRecall RecordBuilder
   */
  public static com.pharbers.kafka.schema.SparkJobRecall.Builder newBuilder() {
    return new com.pharbers.kafka.schema.SparkJobRecall.Builder();
  }

  /**
   * Creates a new SparkJobRecall RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SparkJobRecall RecordBuilder
   */
  public static com.pharbers.kafka.schema.SparkJobRecall.Builder newBuilder(com.pharbers.kafka.schema.SparkJobRecall.Builder other) {
    return new com.pharbers.kafka.schema.SparkJobRecall.Builder(other);
  }

  /**
   * Creates a new SparkJobRecall RecordBuilder by copying an existing SparkJobRecall instance.
   * @param other The existing instance to copy.
   * @return A new SparkJobRecall RecordBuilder
   */
  public static com.pharbers.kafka.schema.SparkJobRecall.Builder newBuilder(com.pharbers.kafka.schema.SparkJobRecall other) {
    return new com.pharbers.kafka.schema.SparkJobRecall.Builder(other);
  }

  /**
   * RecordBuilder for SparkJobRecall instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SparkJobRecall>
    implements org.apache.avro.data.RecordBuilder<SparkJobRecall> {

    private com.pharbers.kafka.schema.Header header;
    private com.pharbers.kafka.schema.Header.Builder headerBuilder;
    private java.lang.CharSequence payload;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pharbers.kafka.schema.SparkJobRecall.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      if (other.hasHeaderBuilder()) {
        this.headerBuilder = com.pharbers.kafka.schema.Header.newBuilder(other.getHeaderBuilder());
      }
      if (isValidValue(fields()[1], other.payload)) {
        this.payload = data().deepCopy(fields()[1].schema(), other.payload);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing SparkJobRecall instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pharbers.kafka.schema.SparkJobRecall other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.header)) {
        this.header = data().deepCopy(fields()[0].schema(), other.header);
        fieldSetFlags()[0] = true;
      }
      this.headerBuilder = null;
      if (isValidValue(fields()[1], other.payload)) {
        this.payload = data().deepCopy(fields()[1].schema(), other.payload);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'header' field.
      * @return The value.
      */
    public com.pharbers.kafka.schema.Header getHeader() {
      return header;
    }

    /**
      * Sets the value of the 'header' field.
      * @param value The value of 'header'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.SparkJobRecall.Builder setHeader(com.pharbers.kafka.schema.Header value) {
      validate(fields()[0], value);
      this.headerBuilder = null;
      this.header = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'header' field has been set.
      * @return True if the 'header' field has been set, false otherwise.
      */
    public boolean hasHeader() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'header' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.pharbers.kafka.schema.Header.Builder getHeaderBuilder() {
      if (headerBuilder == null) {
        if (hasHeader()) {
          setHeaderBuilder(com.pharbers.kafka.schema.Header.newBuilder(header));
        } else {
          setHeaderBuilder(com.pharbers.kafka.schema.Header.newBuilder());
        }
      }
      return headerBuilder;
    }

    /**
     * Sets the Builder instance for the 'header' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public com.pharbers.kafka.schema.SparkJobRecall.Builder setHeaderBuilder(com.pharbers.kafka.schema.Header.Builder value) {
      clearHeader();
      headerBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'header' field has an active Builder instance
     * @return True if the 'header' field has an active Builder instance
     */
    public boolean hasHeaderBuilder() {
      return headerBuilder != null;
    }

    /**
      * Clears the value of the 'header' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.SparkJobRecall.Builder clearHeader() {
      header = null;
      headerBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'payload' field.
      * @return The value.
      */
    public java.lang.CharSequence getPayload() {
      return payload;
    }

    /**
      * Sets the value of the 'payload' field.
      * @param value The value of 'payload'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.SparkJobRecall.Builder setPayload(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.payload = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'payload' field has been set.
      * @return True if the 'payload' field has been set, false otherwise.
      */
    public boolean hasPayload() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'payload' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.SparkJobRecall.Builder clearPayload() {
      payload = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public SparkJobRecall build() {
      try {
        SparkJobRecall record = new SparkJobRecall();
        if (headerBuilder != null) {
          record.header = this.headerBuilder.build();
        } else {
          record.header = fieldSetFlags()[0] ? this.header : (com.pharbers.kafka.schema.Header) defaultValue(fields()[0]);
        }
        record.payload = fieldSetFlags()[1] ? this.payload : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}