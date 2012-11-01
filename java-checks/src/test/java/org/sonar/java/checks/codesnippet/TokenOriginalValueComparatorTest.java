/*
 * Sonar Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.java.checks.codesnippet;

import com.sonar.sslr.api.Token;
import com.sonar.sslr.api.TokenType;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TokenOriginalValueComparatorTest {

  @Test
  public void compare() {
    assertThat(new TokenOriginalValueComparator().compare(mockToken("a"), mockToken("b"))).isEqualTo(-1);
    assertThat(new TokenOriginalValueComparator().compare(mockToken("a"), mockToken("a"))).isEqualTo(0);
    assertThat(new TokenOriginalValueComparator().compare(mockToken("b"), mockToken("a"))).isEqualTo(1);
  }

  private Token mockToken(String value) {
    try {
      return Token.builder()
          .setType(mock(TokenType.class))
          .setValueAndOriginalValue(value)
          .setURI(new URI("test://unit"))
          .setLine(1)
          .setColumn(1)
          .build();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

}
