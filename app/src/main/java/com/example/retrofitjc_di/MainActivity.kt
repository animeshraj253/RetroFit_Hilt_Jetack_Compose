package com.example.retrofitjc_di

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofitjc_di.apiviewmodels.ApiViewModel
import com.example.retrofitjc_di.apiviewmodels.UserUiState
import com.example.retrofitjc_di.dataClasses.UsersItem
import com.example.retrofitjc_di.ui.theme.RetrofitJC_DITheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val apiViewModels : ApiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitJC_DITheme {
                MainUi(apiViewModels)
            }
        }
    }
}
@Composable
fun MainUi(vm : ApiViewModel) {
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()
        , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        )
    {
        Text(text = "API Calling + Hilt + MVVM" , fontWeight = FontWeight.Bold, fontSize = 28.sp)
        when(val state = vm.state.value){
            is UserUiState.Loading -> LoadingUi()
            is UserUiState.Error -> ErrorUi(state.message)
            is UserUiState.Success -> SuccessUi(state.users)
        }
    }
}

@Composable
fun LoadingUi(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun ErrorUi(error: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = error , fontSize =  32.sp, fontWeight = FontWeight.Black, color = Color.Red)
    }
}

@Composable
fun SuccessUi( usersList : List<UsersItem> , modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp))
        {
            items(usersList, key={it.id}){users->
                Card(modifier = Modifier.padding(4.dp).fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ))
                {
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = users.id.toString(),
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = users.name.toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                        }

                        HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))

                        Text(text = "Username: "+users.username, fontSize = 18.sp)
                        Text(text =  "Email: "+users.email, fontSize = 18.sp)
                        Text(text = "Ph.no: "+ users.phone, fontSize = 18.sp)
                    }
                }
            }
        }
    }
}
