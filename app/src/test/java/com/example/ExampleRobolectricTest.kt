package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.repository.BibleRepository
import com.example.data.repository.StrongerCastRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Stronger Cast", appName)
  }

  @Test
  fun `verify bible has all 66 books offline`() {
    val books = BibleRepository.allBooks
    assertEquals(66, books.size)
    val oldTestament = books.filter { it.testament == "AT" }
    val newTestament = books.filter { it.testament == "NT" }
    assertEquals(39, oldTestament.size)
    assertEquals(27, newTestament.size)
  }

  @Test
  fun `verify repository initial data`() {
    val episodes = StrongerCastRepository.episodes.value
    val devotionals = StrongerCastRepository.devotionals.value
    val channels = StrongerCastRepository.channels.value
    assertTrue(episodes.isNotEmpty())
    assertTrue(devotionals.isNotEmpty())
    assertTrue(channels.isNotEmpty())
  }
}
