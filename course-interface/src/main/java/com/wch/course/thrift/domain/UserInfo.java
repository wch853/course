/**
 * Autogenerated by Thrift Compiler (0.11.0)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package com.wch.course.thrift.domain;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
/**
 * 用户信息
 */
public class UserInfo implements org.apache.thrift.TBase<UserInfo, UserInfo._Fields>, java.io.Serializable, Cloneable, Comparable<UserInfo> {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserInfo");

    private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short) 1);
    private static final org.apache.thrift.protocol.TField USERNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("username", org.apache.thrift.protocol.TType.STRING, (short) 2);
    private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short) 3);
    private static final org.apache.thrift.protocol.TField REAL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("realName", org.apache.thrift.protocol.TType.STRING, (short) 4);
    private static final org.apache.thrift.protocol.TField MOBILE_FIELD_DESC = new org.apache.thrift.protocol.TField("mobile", org.apache.thrift.protocol.TType.I64, (short) 5);
    private static final org.apache.thrift.protocol.TField EMAIL_FIELD_DESC = new org.apache.thrift.protocol.TField("email", org.apache.thrift.protocol.TType.STRING, (short) 6);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new UserInfoStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new UserInfoTupleSchemeFactory();

    /**
     * 用户编号
     */
    public int id; // optional
    /**
     * 用户名
     */
    public java.lang.String username; // optional
    /**
     * 密码
     */
    public java.lang.String password; // optional
    /**
     * 真实姓名
     */
    public java.lang.String realName; // optional
    /**
     * 手机号
     */
    public long mobile; // optional
    /**
     * 电子邮箱
     */
    public java.lang.String email; // optional

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        /**
         * 用户编号
         */
        ID((short) 1, "id"),
        /**
         * 用户名
         */
        USERNAME((short) 2, "username"),
        /**
         * 密码
         */
        PASSWORD((short) 3, "password"),
        /**
         * 真实姓名
         */
        REAL_NAME((short) 4, "realName"),
        /**
         * 手机号
         */
        MOBILE((short) 5, "mobile"),
        /**
         * 电子邮箱
         */
        EMAIL((short) 6, "email");

        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

        static {
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        public static _Fields findByThriftId(int fieldId) {
            switch (fieldId) {
                case 1: // ID
                    return ID;
                case 2: // USERNAME
                    return USERNAME;
                case 3: // PASSWORD
                    return PASSWORD;
                case 4: // REAL_NAME
                    return REAL_NAME;
                case 5: // MOBILE
                    return MOBILE;
                case 6: // EMAIL
                    return EMAIL;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception
         * if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        public static _Fields findByName(java.lang.String name) {
            return byName.get(name);
        }

        private final short _thriftId;
        private final java.lang.String _fieldName;

        _Fields(short thriftId, java.lang.String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        public short getThriftFieldId() {
            return _thriftId;
        }

        public java.lang.String getFieldName() {
            return _fieldName;
        }
    }

    // isset id assignments
    private static final int __ID_ISSET_ID = 0;
    private static final int __MOBILE_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    private static final _Fields optionals[] = {_Fields.ID, _Fields.USERNAME, _Fields.PASSWORD, _Fields.REAL_NAME, _Fields.MOBILE, _Fields.EMAIL};
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;

    static {
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32, "INT")));
        tmpMap.put(_Fields.USERNAME, new org.apache.thrift.meta_data.FieldMetaData("username", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        tmpMap.put(_Fields.REAL_NAME, new org.apache.thrift.meta_data.FieldMetaData("realName", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        tmpMap.put(_Fields.MOBILE, new org.apache.thrift.meta_data.FieldMetaData("mobile", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64, "LONG")));
        tmpMap.put(_Fields.EMAIL, new org.apache.thrift.meta_data.FieldMetaData("email", org.apache.thrift.TFieldRequirementType.OPTIONAL,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserInfo.class, metaDataMap);
    }

    public UserInfo() {
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public UserInfo(UserInfo other) {
        __isset_bitfield = other.__isset_bitfield;
        this.id = other.id;
        if (other.isSetUsername()) {
            this.username = other.username;
        }
        if (other.isSetPassword()) {
            this.password = other.password;
        }
        if (other.isSetRealName()) {
            this.realName = other.realName;
        }
        this.mobile = other.mobile;
        if (other.isSetEmail()) {
            this.email = other.email;
        }
    }

    public UserInfo deepCopy() {
        return new UserInfo(this);
    }

    @Override
    public void clear() {
        setIdIsSet(false);
        this.id = 0;
        this.username = null;
        this.password = null;
        this.realName = null;
        setMobileIsSet(false);
        this.mobile = 0;
        this.email = null;
    }

    /**
     * 用户编号
     */
    public int getId() {
        return this.id;
    }

    /**
     * 用户编号
     */
    public UserInfo setId(int id) {
        this.id = id;
        setIdIsSet(true);
        return this;
    }

    public void unsetId() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
    }

    /** Returns true if field id is set (has been assigned a value) and false otherwise */
    public boolean isSetId() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
    }

    public void setIdIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
    }

    /**
     * 用户名
     */
    public java.lang.String getUsername() {
        return this.username;
    }

    /**
     * 用户名
     */
    public UserInfo setUsername(java.lang.String username) {
        this.username = username;
        return this;
    }

    public void unsetUsername() {
        this.username = null;
    }

    /** Returns true if field username is set (has been assigned a value) and false otherwise */
    public boolean isSetUsername() {
        return this.username != null;
    }

    public void setUsernameIsSet(boolean value) {
        if (!value) {
            this.username = null;
        }
    }

    /**
     * 密码
     */
    public java.lang.String getPassword() {
        return this.password;
    }

    /**
     * 密码
     */
    public UserInfo setPassword(java.lang.String password) {
        this.password = password;
        return this;
    }

    public void unsetPassword() {
        this.password = null;
    }

    /** Returns true if field password is set (has been assigned a value) and false otherwise */
    public boolean isSetPassword() {
        return this.password != null;
    }

    public void setPasswordIsSet(boolean value) {
        if (!value) {
            this.password = null;
        }
    }

    /**
     * 真实姓名
     */
    public java.lang.String getRealName() {
        return this.realName;
    }

    /**
     * 真实姓名
     */
    public UserInfo setRealName(java.lang.String realName) {
        this.realName = realName;
        return this;
    }

    public void unsetRealName() {
        this.realName = null;
    }

    /** Returns true if field realName is set (has been assigned a value) and false otherwise */
    public boolean isSetRealName() {
        return this.realName != null;
    }

    public void setRealNameIsSet(boolean value) {
        if (!value) {
            this.realName = null;
        }
    }

    /**
     * 手机号
     */
    public long getMobile() {
        return this.mobile;
    }

    /**
     * 手机号
     */
    public UserInfo setMobile(long mobile) {
        this.mobile = mobile;
        setMobileIsSet(true);
        return this;
    }

    public void unsetMobile() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MOBILE_ISSET_ID);
    }

    /** Returns true if field mobile is set (has been assigned a value) and false otherwise */
    public boolean isSetMobile() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MOBILE_ISSET_ID);
    }

    public void setMobileIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MOBILE_ISSET_ID, value);
    }

    /**
     * 电子邮箱
     */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
     * 电子邮箱
     */
    public UserInfo setEmail(java.lang.String email) {
        this.email = email;
        return this;
    }

    public void unsetEmail() {
        this.email = null;
    }

    /** Returns true if field email is set (has been assigned a value) and false otherwise */
    public boolean isSetEmail() {
        return this.email != null;
    }

    public void setEmailIsSet(boolean value) {
        if (!value) {
            this.email = null;
        }
    }

    public void setFieldValue(_Fields field, java.lang.Object value) {
        switch (field) {
            case ID:
                if (value == null) {
                    unsetId();
                } else {
                    setId((java.lang.Integer) value);
                }
                break;

            case USERNAME:
                if (value == null) {
                    unsetUsername();
                } else {
                    setUsername((java.lang.String) value);
                }
                break;

            case PASSWORD:
                if (value == null) {
                    unsetPassword();
                } else {
                    setPassword((java.lang.String) value);
                }
                break;

            case REAL_NAME:
                if (value == null) {
                    unsetRealName();
                } else {
                    setRealName((java.lang.String) value);
                }
                break;

            case MOBILE:
                if (value == null) {
                    unsetMobile();
                } else {
                    setMobile((java.lang.Long) value);
                }
                break;

            case EMAIL:
                if (value == null) {
                    unsetEmail();
                } else {
                    setEmail((java.lang.String) value);
                }
                break;

        }
    }

    public java.lang.Object getFieldValue(_Fields field) {
        switch (field) {
            case ID:
                return getId();

            case USERNAME:
                return getUsername();

            case PASSWORD:
                return getPassword();

            case REAL_NAME:
                return getRealName();

            case MOBILE:
                return getMobile();

            case EMAIL:
                return getEmail();

        }
        throw new java.lang.IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new java.lang.IllegalArgumentException();
        }

        switch (field) {
            case ID:
                return isSetId();
            case USERNAME:
                return isSetUsername();
            case PASSWORD:
                return isSetPassword();
            case REAL_NAME:
                return isSetRealName();
            case MOBILE:
                return isSetMobile();
            case EMAIL:
                return isSetEmail();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override
    public boolean equals(java.lang.Object that) {
        if (that == null)
            return false;
        if (that instanceof UserInfo)
            return this.equals((UserInfo) that);
        return false;
    }

    public boolean equals(UserInfo that) {
        if (that == null)
            return false;
        if (this == that)
            return true;

        boolean this_present_id = true && this.isSetId();
        boolean that_present_id = true && that.isSetId();
        if (this_present_id || that_present_id) {
            if (!(this_present_id && that_present_id))
                return false;
            if (this.id != that.id)
                return false;
        }

        boolean this_present_username = true && this.isSetUsername();
        boolean that_present_username = true && that.isSetUsername();
        if (this_present_username || that_present_username) {
            if (!(this_present_username && that_present_username))
                return false;
            if (!this.username.equals(that.username))
                return false;
        }

        boolean this_present_password = true && this.isSetPassword();
        boolean that_present_password = true && that.isSetPassword();
        if (this_present_password || that_present_password) {
            if (!(this_present_password && that_present_password))
                return false;
            if (!this.password.equals(that.password))
                return false;
        }

        boolean this_present_realName = true && this.isSetRealName();
        boolean that_present_realName = true && that.isSetRealName();
        if (this_present_realName || that_present_realName) {
            if (!(this_present_realName && that_present_realName))
                return false;
            if (!this.realName.equals(that.realName))
                return false;
        }

        boolean this_present_mobile = true && this.isSetMobile();
        boolean that_present_mobile = true && that.isSetMobile();
        if (this_present_mobile || that_present_mobile) {
            if (!(this_present_mobile && that_present_mobile))
                return false;
            if (this.mobile != that.mobile)
                return false;
        }

        boolean this_present_email = true && this.isSetEmail();
        boolean that_present_email = true && that.isSetEmail();
        if (this_present_email || that_present_email) {
            if (!(this_present_email && that_present_email))
                return false;
            if (!this.email.equals(that.email))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 8191 + ((isSetId()) ? 131071 : 524287);
        if (isSetId())
            hashCode = hashCode * 8191 + id;

        hashCode = hashCode * 8191 + ((isSetUsername()) ? 131071 : 524287);
        if (isSetUsername())
            hashCode = hashCode * 8191 + username.hashCode();

        hashCode = hashCode * 8191 + ((isSetPassword()) ? 131071 : 524287);
        if (isSetPassword())
            hashCode = hashCode * 8191 + password.hashCode();

        hashCode = hashCode * 8191 + ((isSetRealName()) ? 131071 : 524287);
        if (isSetRealName())
            hashCode = hashCode * 8191 + realName.hashCode();

        hashCode = hashCode * 8191 + ((isSetMobile()) ? 131071 : 524287);
        if (isSetMobile())
            hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(mobile);

        hashCode = hashCode * 8191 + ((isSetEmail()) ? 131071 : 524287);
        if (isSetEmail())
            hashCode = hashCode * 8191 + email.hashCode();

        return hashCode;
    }

    @Override
    public int compareTo(UserInfo other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;

        lastComparison = java.lang.Boolean.valueOf(isSetId()).compareTo(other.isSetId());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetId()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetUsername()).compareTo(other.isSetUsername());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetUsername()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.username, other.username);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetPassword()).compareTo(other.isSetPassword());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetPassword()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, other.password);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetRealName()).compareTo(other.isSetRealName());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetRealName()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.realName, other.realName);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetMobile()).compareTo(other.isSetMobile());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetMobile()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mobile, other.mobile);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetEmail()).compareTo(other.isSetEmail());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetEmail()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.email, other.email);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        return 0;
    }

    public _Fields fieldForId(int fieldId) {
        return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        scheme(iprot).read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        scheme(oprot).write(oprot, this);
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("UserInfo(");
        boolean first = true;

        if (isSetId()) {
            sb.append("id:");
            sb.append(this.id);
            first = false;
        }
        if (isSetUsername()) {
            if (!first) sb.append(", ");
            sb.append("username:");
            if (this.username == null) {
                sb.append("null");
            } else {
                sb.append(this.username);
            }
            first = false;
        }
        if (isSetPassword()) {
            if (!first) sb.append(", ");
            sb.append("password:");
            if (this.password == null) {
                sb.append("null");
            } else {
                sb.append(this.password);
            }
            first = false;
        }
        if (isSetRealName()) {
            if (!first) sb.append(", ");
            sb.append("realName:");
            if (this.realName == null) {
                sb.append("null");
            } else {
                sb.append(this.realName);
            }
            first = false;
        }
        if (isSetMobile()) {
            if (!first) sb.append(", ");
            sb.append("mobile:");
            sb.append(this.mobile);
            first = false;
        }
        if (isSetEmail()) {
            if (!first) sb.append(", ");
            sb.append("email:");
            if (this.email == null) {
                sb.append("null");
            } else {
                sb.append(this.email);
            }
            first = false;
        }
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
        // check for required fields
        // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        try {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
            __isset_bitfield = 0;
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private static class UserInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public UserInfoStandardScheme getScheme() {
            return new UserInfoStandardScheme();
        }
    }

    private static class UserInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<UserInfo> {

        public void read(org.apache.thrift.protocol.TProtocol iprot, UserInfo struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // ID
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            struct.id = iprot.readI32();
                            struct.setIdIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // USERNAME
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.username = iprot.readString();
                            struct.setUsernameIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 3: // PASSWORD
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.password = iprot.readString();
                            struct.setPasswordIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 4: // REAL_NAME
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.realName = iprot.readString();
                            struct.setRealNameIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 5: // MOBILE
                        if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
                            struct.mobile = iprot.readI64();
                            struct.setMobileIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 6: // EMAIL
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.email = iprot.readString();
                            struct.setEmailIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            // check for required fields of primitive type, which can't be checked in the validate method
            struct.validate();
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot, UserInfo struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            if (struct.isSetId()) {
                oprot.writeFieldBegin(ID_FIELD_DESC);
                oprot.writeI32(struct.id);
                oprot.writeFieldEnd();
            }
            if (struct.username != null) {
                if (struct.isSetUsername()) {
                    oprot.writeFieldBegin(USERNAME_FIELD_DESC);
                    oprot.writeString(struct.username);
                    oprot.writeFieldEnd();
                }
            }
            if (struct.password != null) {
                if (struct.isSetPassword()) {
                    oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
                    oprot.writeString(struct.password);
                    oprot.writeFieldEnd();
                }
            }
            if (struct.realName != null) {
                if (struct.isSetRealName()) {
                    oprot.writeFieldBegin(REAL_NAME_FIELD_DESC);
                    oprot.writeString(struct.realName);
                    oprot.writeFieldEnd();
                }
            }
            if (struct.isSetMobile()) {
                oprot.writeFieldBegin(MOBILE_FIELD_DESC);
                oprot.writeI64(struct.mobile);
                oprot.writeFieldEnd();
            }
            if (struct.email != null) {
                if (struct.isSetEmail()) {
                    oprot.writeFieldBegin(EMAIL_FIELD_DESC);
                    oprot.writeString(struct.email);
                    oprot.writeFieldEnd();
                }
            }
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class UserInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public UserInfoTupleScheme getScheme() {
            return new UserInfoTupleScheme();
        }
    }

    private static class UserInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<UserInfo> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, UserInfo struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet optionals = new java.util.BitSet();
            if (struct.isSetId()) {
                optionals.set(0);
            }
            if (struct.isSetUsername()) {
                optionals.set(1);
            }
            if (struct.isSetPassword()) {
                optionals.set(2);
            }
            if (struct.isSetRealName()) {
                optionals.set(3);
            }
            if (struct.isSetMobile()) {
                optionals.set(4);
            }
            if (struct.isSetEmail()) {
                optionals.set(5);
            }
            oprot.writeBitSet(optionals, 6);
            if (struct.isSetId()) {
                oprot.writeI32(struct.id);
            }
            if (struct.isSetUsername()) {
                oprot.writeString(struct.username);
            }
            if (struct.isSetPassword()) {
                oprot.writeString(struct.password);
            }
            if (struct.isSetRealName()) {
                oprot.writeString(struct.realName);
            }
            if (struct.isSetMobile()) {
                oprot.writeI64(struct.mobile);
            }
            if (struct.isSetEmail()) {
                oprot.writeString(struct.email);
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, UserInfo struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet incoming = iprot.readBitSet(6);
            if (incoming.get(0)) {
                struct.id = iprot.readI32();
                struct.setIdIsSet(true);
            }
            if (incoming.get(1)) {
                struct.username = iprot.readString();
                struct.setUsernameIsSet(true);
            }
            if (incoming.get(2)) {
                struct.password = iprot.readString();
                struct.setPasswordIsSet(true);
            }
            if (incoming.get(3)) {
                struct.realName = iprot.readString();
                struct.setRealNameIsSet(true);
            }
            if (incoming.get(4)) {
                struct.mobile = iprot.readI64();
                struct.setMobileIsSet(true);
            }
            if (incoming.get(5)) {
                struct.email = iprot.readString();
                struct.setEmailIsSet(true);
            }
        }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
