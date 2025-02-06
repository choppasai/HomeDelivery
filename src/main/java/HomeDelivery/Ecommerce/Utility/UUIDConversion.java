package HomeDelivery.Ecommerce.Utility;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.nio.ByteBuffer;
import java.util.UUID;
@Converter(autoApply = true)
public class UUIDConversion implements AttributeConverter<UUID,byte[]> {
    @Override
    public byte[] convertToDatabaseColumn(UUID uuid) {
        if(uuid == null)
            return  null;
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());

        return byteBuffer.array();
    }

    @Override
    public UUID convertToEntityAttribute(byte[] bytes) {
        if(bytes == null)
            return null;
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        long msb = byteBuffer.getLong();
        long lsb = byteBuffer.getLong();
        return new UUID(msb,lsb);
    }
}
