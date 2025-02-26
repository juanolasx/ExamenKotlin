package com.example.examenfinalkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examenfinalkotlin.data.Model.Post
import com.example.examenfinalkotlin.data.Repositores.PostByNameRepository
import com.example.examenfinalkotlin.data.Repositores.PostRepository
import com.example.examenfinalkotlin.ui.theme.Screens.Users.PostDetailScreen
import com.example.examenfinalkotlin.ui.theme.Screens.Users.PostListScreen
import com.example.examenfinalkotlin.ui.theme.theme.ExamenFinalKotlinTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val postRepository = PostRepository()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var Posts by mutableStateOf<List<Post>?>(null)

        lifecycleScope.launch {
            Posts = postRepository.fetchPost()
        }

        setContent {
            MaterialTheme {
                val navController = rememberNavController()

    //aqui creo el scaffold donde le indico que el titulo sea lista de productos...
    // y le meto colores con el topAppbarcolores uno al titulo.
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Lista de Productos Del la API JSONHOLDER") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimary
                            )
                        )

                    }
                ) { paddingValues ->
                    Surface(modifier = Modifier.padding(paddingValues)) {
                        NavHost(navController, startDestination = "productList") {
                            composable("productList") {
                                PostListScreen(
                                    Posts = Posts,
                                    onPostClick = { product ->
                                        navController.navigate("productDetail/${product.id}")
                                    }
                                )
                            }

                            composable("productDetail/{productId}") { backStackEntry ->
                                val PostsId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
                                val selectedProduct = Posts?.find { it.id == PostsId }
                                selectedProduct?.let {
                                    PostDetailScreen(it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}