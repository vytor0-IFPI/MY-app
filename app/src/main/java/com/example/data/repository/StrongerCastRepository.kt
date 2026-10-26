package com.example.data.repository

import com.example.data.model.Devotional
import com.example.data.model.Episode
import com.example.data.model.RecommendedChannel
import com.example.data.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object StrongerCastRepository {

    // Supabase Settings (Configurável pelo usuário na tela de Configurações)
    var supabaseUrl: String = "https://your-project.supabase.co"
    var supabaseAnonKey: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    var isConnectedToSupabase: Boolean = false

    // Estado do Usuário Logado
    private val _currentUser = MutableStateFlow<UserProfile?>(
        UserProfile(
            id = "demo-admin-id",
            email = "admin@strongercast.com",
            nome = "Jovem Cristão",
            admin = true // Pré-configurado como admin para teste e gestão imediata
        )
    )
    val currentUser: StateFlow<UserProfile?> = _currentUser.asStateFlow()

    // Episódios
    private val _episodes = MutableStateFlow<List<Episode>>(
        listOf(
            Episode(
                id = 1,
                titulo = "#01 · Identidade Inabalável na Juventude",
                convidado = "Pr. Lucas Santana",
                data = "24/10/2026",
                youtube = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                spotify = "https://open.spotify.com/show/strongercast",
                mp3 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
                capa = "https://images.unsplash.com/photo-1519791883288-dc8bd696e667?w=800&auto=format&fit=crop&q=80",
                publicado = true
            ),
            Episode(
                id = 2,
                titulo = "#02 · Vencendo a Ansiedade com Fé Real",
                convidado = "Dra. Gabriela Nunes (Psicóloga)",
                data = "17/10/2026",
                youtube = "https://www.youtube.com/watch?v=ScMzIvxBSi4",
                spotify = "https://open.spotify.com/show/strongercast",
                mp3 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3",
                capa = "https://images.unsplash.com/photo-1499209974431-9dddcece7f88?w=800&auto=format&fit=crop&q=80",
                publicado = true
            ),
            Episode(
                id = 3,
                titulo = "#03 · Propósito & Carreira: Onde Deus Te Quer?",
                convidado = "Felipe Rocha (Empreendedor)",
                data = "10/10/2026",
                youtube = "https://www.youtube.com/watch?v=9bZkp7q19f0",
                spotify = "https://open.spotify.com/show/strongercast",
                mp3 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3",
                capa = "https://images.unsplash.com/photo-1507679799987-c73779587ccf?w=800&auto=format&fit=crop&q=80",
                publicado = true
            ),
            Episode(
                id = 4,
                titulo = "#04 · Relacionamentos e Santidade na Prática",
                convidado = "Sarah & Tiago Oliveira",
                data = "03/10/2026",
                youtube = "https://www.youtube.com/watch?v=kXYiU_JCYtU",
                spotify = "https://open.spotify.com/show/strongercast",
                mp3 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-4.mp3",
                capa = "https://images.unsplash.com/photo-1529156069898-49953e39b3ac?w=800&auto=format&fit=crop&q=80",
                publicado = true
            )
        )
    )
    val episodes: StateFlow<List<Episode>> = _episodes.asStateFlow()

    // Devocionais (do mais recente para o mais antigo)
    private val _devotionals = MutableStateFlow<List<Devotional>>(
        listOf(
            Devotional(
                id = 1,
                titulo = "A Certeza daquilo que não vemos",
                versiculo = "Hebreus 11.1",
                texto = "Ora, a fé é a certeza daquilo que esperamos e a convicção do que não vemos. Quando o mundo cobra provas imediatas e palpáveis, a fé nos ancora na fidelidade eterna de Deus. Não baseie sua caminhada pelo que seus olhos naturais observam hoje; firme seus passos na promessa Daquele que é fiel para cumprir.",
                data = "25/10/2026",
                publicado = true
            ),
            Devotional(
                id = 2,
                titulo = "Coragem no Meio da Tempestade",
                versiculo = "Josué 1.9",
                texto = "Não fui eu que lhe ordenei? Seja forte e corajoso! Não se apavore nem desanime, pois o Senhor, o seu Deus, estará com você por onde você andar. A coragem não é ausência de medo, mas a certeza inegociável de que Deus é maior que qualquer desafio na sua universidade, trabalho ou família.",
                data = "23/10/2026",
                publicado = true
            ),
            Devotional(
                id = 3,
                titulo = "Renovando a Mente Diariamente",
                versiculo = "Romanos 12.2",
                texto = "E não vos conformeis com este século, mas transformai-vos pela renovação da vossa mente, para que experimenteis qual seja a boa, agradável e perfeita vontade de Deus. Filtre o que entra pelas suas telas e ouvidos. Alimente seu espírito com a Verdade da Palavra viva.",
                data = "20/10/2026",
                publicado = true
            ),
            Devotional(
                id = 4,
                titulo = "Força Sobrenatural em Cristo",
                versiculo = "Filipenses 4.13",
                texto = "Tudo posso naquele que me fortalece. Este versículo não fala de superpoderes egoístas, mas sobre ter contentamento e perseverança santa tanto na abundância quanto na escassez, sabendo que a graça de Cristo é o nosso suprimento diário inesgotável.",
                data = "16/10/2026",
                publicado = true
            )
        )
    )
    val devotionals: StateFlow<List<Devotional>> = _devotionals.asStateFlow()

    // Canais e Vídeos Recomendados
    private val _channels = MutableStateFlow<List<RecommendedChannel>>(
        listOf(
            RecommendedChannel(
                id = 1,
                titulo = "Como Ouvir a Voz de Deus com Clareza",
                canal = "Deive Leonardo",
                link = "https://www.youtube.com/watch?v=aircAruvnKk",
                tipo = "video",
                publicado = true
            ),
            RecommendedChannel(
                id = 2,
                titulo = "Dunamis Movement Oficial",
                canal = "Dunamis Movement",
                link = "https://www.youtube.com/@DunamisMovement",
                tipo = "canal",
                publicado = true
            ),
            RecommendedChannel(
                id = 3,
                titulo = "Lidando com Pressão e Expectativas",
                canal = "Teo Hayashi",
                link = "https://www.youtube.com/watch?v=kJQP7kiw5Fk",
                tipo = "video",
                publicado = true
            ),
            RecommendedChannel(
                id = 4,
                titulo = "Canal JesusCopy",
                canal = "Douglas Gonçalves",
                link = "https://www.youtube.com/@Jesuscopy",
                tipo = "canal",
                publicado = true
            )
        )
    )
    val channels: StateFlow<List<RecommendedChannel>> = _channels.asStateFlow()

    // AUTH METHODS
    fun login(email: String, pass: String): Result<UserProfile> {
        if (email.isBlank() || pass.length < 6) {
            return Result.failure(Exception("E-mail inválido ou senha com menos de 6 caracteres."))
        }
        val isAdmin = email.contains("admin", ignoreCase = true)
        val profile = UserProfile(
            id = "user-${System.currentTimeMillis()}",
            email = email,
            nome = email.substringBefore("@"),
            admin = isAdmin
        )
        _currentUser.value = profile
        return Result.success(profile)
    }

    fun register(email: String, pass: String, nome: String): Result<UserProfile> {
        if (email.isBlank() || pass.length < 6) {
            return Result.failure(Exception("Preencha um e-mail válido e senha mínima de 6 caracteres."))
        }
        val isAdmin = email.contains("admin", ignoreCase = true)
        val profile = UserProfile(
            id = "user-${System.currentTimeMillis()}",
            email = email,
            nome = if (nome.isNotBlank()) nome else email.substringBefore("@"),
            admin = isAdmin
        )
        _currentUser.value = profile
        return Result.success(profile)
    }

    fun logout() {
        _currentUser.value = null
    }

    fun toggleAdmin() {
        val user = _currentUser.value ?: return
        _currentUser.value = user.copy(admin = !user.admin)
    }

    // EPISODES CRUD
    fun saveEpisode(episode: Episode) {
        val currentList = _episodes.value.toMutableList()
        val index = currentList.indexOfFirst { it.id == episode.id }
        if (index >= 0) {
            currentList[index] = episode
        } else {
            val newId = (currentList.maxOfOrNull { it.id } ?: 0L) + 1L
            currentList.add(0, episode.copy(id = newId))
        }
        _episodes.value = currentList
    }

    fun deleteEpisode(id: Long) {
        _episodes.value = _episodes.value.filterNot { it.id == id }
    }

    // DEVOTIONALS CRUD
    fun saveDevotional(devotional: Devotional) {
        val currentList = _devotionals.value.toMutableList()
        val index = currentList.indexOfFirst { it.id == devotional.id }
        if (index >= 0) {
            currentList[index] = devotional
        } else {
            val newId = (currentList.maxOfOrNull { it.id } ?: 0L) + 1L
            currentList.add(0, devotional.copy(id = newId))
        }
        _devotionals.value = currentList
    }

    fun deleteDevotional(id: Long) {
        _devotionals.value = _devotionals.value.filterNot { it.id == id }
    }

    // CHANNELS CRUD
    fun saveChannel(channel: RecommendedChannel) {
        val currentList = _channels.value.toMutableList()
        val index = currentList.indexOfFirst { it.id == channel.id }
        val autoTipo = if (isYouTubeVideoLink(channel.link)) "video" else "canal"
        val itemWithTipo = channel.copy(tipo = autoTipo)
        if (index >= 0) {
            currentList[index] = itemWithTipo
        } else {
            val newId = (currentList.maxOfOrNull { it.id } ?: 0L) + 1L
            currentList.add(itemWithTipo.copy(id = newId))
        }
        _channels.value = currentList
    }

    fun deleteChannel(id: Long) {
        _channels.value = _channels.value.filterNot { it.id == id }
    }

    // Identificação automática de link de vídeo vs canal
    fun isYouTubeVideoLink(url: String): Boolean {
        val lower = url.lowercase().trim()
        return lower.contains("watch?v=") ||
                lower.contains("youtu.be/") ||
                lower.contains("/shorts/") ||
                lower.contains("youtube.com/embed/")
    }

    fun extractYouTubeVideoId(url: String): String? {
        val trimmed = url.trim()
        return try {
            when {
                trimmed.contains("youtu.be/") -> trimmed.substringAfter("youtu.be/").substringBefore("?").substringBefore("&")
                trimmed.contains("watch?v=") -> trimmed.substringAfter("watch?v=").substringBefore("&")
                trimmed.contains("/shorts/") -> trimmed.substringAfter("/shorts/").substringBefore("?").substringBefore("&")
                trimmed.contains("/embed/") -> trimmed.substringAfter("/embed/").substringBefore("?").substringBefore("&")
                else -> null
            }
        } catch (e: Exception) {
            null
        }
    }
}
