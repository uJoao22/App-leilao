package br.com.selecao.locadora.converter;

import br.com.selecao.locadora.entity.Comprador.CompradorId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompradorIdConverter implements Converter<String, CompradorId> {

  @Override
  public CompradorId convert(String source) {
    String[] parts = source.split(",");

    if (parts.length != 2)
      throw new RuntimeException("Invalid CompradorId format");

    return new CompradorId(Long.valueOf(parts[0]), Long.valueOf(parts[1]));
  }
}