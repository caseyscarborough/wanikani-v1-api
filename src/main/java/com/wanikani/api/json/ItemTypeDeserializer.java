package com.wanikani.api.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.wanikani.api.model.ItemType;

import java.io.IOException;

public class ItemTypeDeserializer extends JsonDeserializer<ItemType> {

  @Override
  public ItemType deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
    return ItemType.findByName(parser.getText());
  }
}
