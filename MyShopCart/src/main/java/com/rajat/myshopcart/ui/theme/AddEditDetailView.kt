package eu.rajat.myshopcart.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import eu.rajat.myshopcart.AppBarView
import eu.rajat.myshopcart.R
import eu.rajat.myshopcart.data.Item
import kotlinx.coroutines.launch

@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: ItemViewModel,
    navController: NavController
) {
    val snackMessage = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    if (id != 0L) {
        val item = viewModel.getAnItemById(id).collectAsState(initial = Item(0L, "", ""))
        viewModel.itemTitleState = item.value.title
        viewModel.itemDescriptionState = item.value.description
    } else {
        viewModel.itemTitleState = ""
        viewModel.itemDescriptionState = ""
    }

    Scaffold(
        topBar = {
            AppBarView(
                title = if (id != 0L) stringResource(id = R.string.update_item)
                else stringResource(id = R.string.add_item)
            ) { navController.navigateUp() }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            ItemTextField(
                label = "Title",
                value = viewModel.itemTitleState,
                onValueChanged = { viewModel.onItemTitleChanged(it) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            ItemTextField(
                label = "Quantity",
                value = viewModel.itemDescriptionState,
                onValueChanged = { viewModel.onItemDescriptionChanged(it) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            androidx.compose.material.Button(onClick = {
                if (viewModel.itemTitleState.isNotEmpty() &&
                    viewModel.itemDescriptionState.isNotEmpty()
                ) {
                    if (id != 0L) {
                        viewModel.updateItem(
                            Item(
                                id = id,
                                title = viewModel.itemTitleState.trim(),
                                description = viewModel.itemDescriptionState.trim()
                            )
                        )
                    } else {
                        viewModel.addItem(
                            Item(
                                title = viewModel.itemTitleState.trim(),
                                description = viewModel.itemDescriptionState.trim()
                            )
                        )
                        snackMessage.value = "Item has been created"
                    }
                } else {
                    snackMessage.value = "Enter fields to create an item"
                }

                scope.launch {
                    navController.navigateUp()
                }

            }) {
                androidx.compose.material3.Text(
                    text = if (id != 0L) stringResource(id = R.string.update_item)
                    else stringResource(id = R.string.add_item),
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }
    }
}

@Composable
fun ItemTextField(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { androidx.compose.material3.Text(text = label, color = Color.Black) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedBorderColor = colorResource(id = R.color.black),
            unfocusedBorderColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black),
        )
    )
}

