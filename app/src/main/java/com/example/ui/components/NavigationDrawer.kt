package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudQueue
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Podcasts
import androidx.compose.material.icons.filled.Subscriptions
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.repository.StrongerCastRepository
import com.example.ui.theme.DarkBackground
import com.example.ui.theme.DarkCardBorder
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceElevated
import com.example.ui.theme.GoldPrimary
import com.example.ui.theme.GoldSecondary
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

enum class Screen {
    EPISODES,
    BIBLE,
    DEVOTIONALS,
    CHANNELS,
    ADMIN_PANEL,
    ACCOUNT,
    SUPABASE_CONFIG
}

@Composable
fun StrongerHeader(
    title: String,
    onOpenDrawer: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkBackground)
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = onOpenDrawer,
                modifier = Modifier
                    .size(42.dp)
                    .testTag("menu_hamburger_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Abrir Menu Lateral",
                    tint = GoldPrimary
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Emblema circular "S"
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.linearGradient(listOf(GoldPrimary, GoldSecondary))
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "S",
                    color = Color(0xFF141414),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    text = "STRONGER CAST",
                    color = GoldPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp
                )
                Text(
                    text = title,
                    color = TextSecondary,
                    fontSize = 11.sp
                )
            }
        }
    }
}

@Composable
fun StrongerDrawerContent(
    currentScreen: Screen,
    onNavigate: (Screen) -> Unit,
    onCloseDrawer: () -> Unit
) {
    val user by StrongerCastRepository.currentUser.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(DarkSurface)
            .statusBarsPadding()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            // Header do Drawer com Marca
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, GoldPrimary, CircleShape)
                        .background(
                            Brush.linearGradient(listOf(GoldPrimary, GoldSecondary))
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "S",
                        color = Color(0xFF141414),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Black
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        text = "Stronger Cast",
                        color = GoldPrimary,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Fé inabalável para jovens",
                        color = TextSecondary,
                        fontSize = 11.sp
                    )
                }
            }

            HorizontalDivider(color = DarkCardBorder, thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            // Itens de Navegação Obrigatórios
            DrawerItem(
                label = "Episódios",
                icon = Icons.Default.Podcasts,
                isSelected = currentScreen == Screen.EPISODES,
                onClick = {
                    onNavigate(Screen.EPISODES)
                    onCloseDrawer()
                }
            )

            DrawerItem(
                label = "Bíblia (Offline)",
                icon = Icons.AutoMirrored.Filled.MenuBook,
                isSelected = currentScreen == Screen.BIBLE,
                badge = "66 Livros",
                onClick = {
                    onNavigate(Screen.BIBLE)
                    onCloseDrawer()
                }
            )

            DrawerItem(
                label = "Devocionais",
                icon = Icons.Default.AutoAwesome,
                isSelected = currentScreen == Screen.DEVOTIONALS,
                onClick = {
                    onNavigate(Screen.DEVOTIONALS)
                    onCloseDrawer()
                }
            )

            DrawerItem(
                label = "Canais Recomendados",
                icon = Icons.Default.Subscriptions,
                isSelected = currentScreen == Screen.CHANNELS,
                onClick = {
                    onNavigate(Screen.CHANNELS)
                    onCloseDrawer()
                }
            )

            // PAINEL DO ADMIN (visível apenas para admin)
            if (user?.admin == true) {
                Spacer(modifier = Modifier.height(6.dp))
                DrawerItem(
                    label = "Painel do Admin",
                    icon = Icons.Default.AdminPanelSettings,
                    isSelected = currentScreen == Screen.ADMIN_PANEL,
                    isSpecialAdmin = true,
                    onClick = {
                        onNavigate(Screen.ADMIN_PANEL)
                        onCloseDrawer()
                    }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = DarkCardBorder, thickness = 1.dp)
            Spacer(modifier = Modifier.height(10.dp))

            DrawerItem(
                label = "Sua Conta",
                icon = Icons.Default.Person,
                isSelected = currentScreen == Screen.ACCOUNT,
                subtitle = user?.email ?: "Entrar / Cadastrar",
                onClick = {
                    onNavigate(Screen.ACCOUNT)
                    onCloseDrawer()
                }
            )

            DrawerItem(
                label = "Banco & SQL (Supabase)",
                icon = Icons.Default.CloudQueue,
                isSelected = currentScreen == Screen.SUPABASE_CONFIG,
                onClick = {
                    onNavigate(Screen.SUPABASE_CONFIG)
                    onCloseDrawer()
                }
            )
        }

        // Rodapé com status do app
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            HorizontalDivider(color = DarkCardBorder, thickness = 1.dp)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Stronger Cast v1.0",
                    color = TextMuted,
                    fontSize = 11.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF4CAF50))
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "100% Offline pronto",
                        color = TextMuted,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun DrawerItem(
    label: String,
    icon: ImageVector,
    isSelected: Boolean,
    badge: String? = null,
    subtitle: String? = null,
    isSpecialAdmin: Boolean = false,
    onClick: () -> Unit
) {
    val bgModifier = if (isSelected) {
        Modifier.background(DarkSurfaceElevated, RoundedCornerShape(12.dp))
    } else {
        Modifier
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(bgModifier)
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (isSpecialAdmin) GoldSecondary else if (isSelected) GoldPrimary else TextSecondary,
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column {
                Text(
                    text = label,
                    color = if (isSpecialAdmin) GoldPrimary else if (isSelected) TextPrimary else TextSecondary,
                    fontSize = 14.sp,
                    fontWeight = if (isSelected || isSpecialAdmin) FontWeight.Bold else FontWeight.Normal
                )
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        color = TextMuted,
                        fontSize = 11.sp,
                        maxLines = 1
                    )
                }
            }
        }

        if (badge != null) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(DarkSurfaceElevated)
                    .border(0.5.dp, GoldSecondary, RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                Text(
                    text = badge,
                    color = GoldPrimary,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
