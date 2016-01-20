package com.martinrist.sandbox.collections;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CollectionViewTest {

    Map<String, String> frenchNumberTranslations = new HashMap<String, String>() {{
        put("One", "Un");
        put("Two", "Deux");
        put("Three", "Trois");
        put("Four", "Quatre");
    }};

    @Test
    public void testKeySetView_RemovingKeyRemovesEntryFromMap() {
        Set<String> keys = frenchNumberTranslations.keySet();
        keys.remove("Four");

        assertEquals("Un", frenchNumberTranslations.get("One"));
        assertEquals("Deux", frenchNumberTranslations.get("Two"));
        assertEquals("Trois", frenchNumberTranslations.get("Three"));
        assertFalse(frenchNumberTranslations.containsKey("Four"));
    }

    @Test
    public void testValuesView_UpdatingUnderlyingMapChangesView() {
        Collection<String> values = frenchNumberTranslations.values();
        frenchNumberTranslations.put("Four", "Quattro");  // Oops - switched to Italian.

        assertTrue(values.contains("Un"));
        assertTrue(values.contains("Deux"));
        assertTrue(values.contains("Trois"));
        assertFalse(values.contains("Quatre"));
        assertTrue(values.contains("Quattro"));
    }

}
