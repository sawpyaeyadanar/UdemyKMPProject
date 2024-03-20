package com.example.myfirstkmmapp.articles.presentation

import com.example.myfirstkmmapp.BaseViewModel
import com.example.myfirstkmmapp.articles.application.ArticlesUseCase
import com.example.myfirstkmmapp.articles.presentation.ArticlesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel( private val useCase: ArticlesUseCase): BaseViewModel() {
    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }
    fun getArticles(forceFetch: Boolean = false) {
        // scope က BaseViewModel ကို inheritence လုပ်မှ ပေါ်တာ
        scope.launch {
            val fetchedArticles = useCase.getArticles(forceFetch)
            // articleState မှာ ၃ခုရှိတာ article list တခုတည်းကိုပဲ တန်ဖိုးပေးလို့ရတယ်
            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    /*
    private suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            title = "Exploring the Mysteries of Deep Space",
            desc = "Delve into the depths of the cosmos as we uncover the secrets hidden within the vast expanse of space.",
            date = "February 14, 2024",
            imageUrl = "https://images.ctfassets.net/lzny33ho1g45/T5qqQQVznbZaNyxmHybDT/5f7580349045322d572a078262bee1b8/Best_URL_shortener.jpg?w=1520&fm=jpg&q=30&fit=thumb&h=760"
        ),
        Article(
            title = "The Art of Cooking: A Culinary Journey",
            desc = "Embark on a gastronomic adventure through the flavors and techniques of the world's cuisines.",
            date = "February 10, 2024",
            imageUrl = "https://media.licdn.com/dms/image/C4D12AQG2y-WaF3hKog/article-cover_image-shrink_600_2000/0/1606307970972?e=2147483647&v=beta&t=4SVDtZIgo0t-dlfhqk9Udm3sl2POvLlbynr0TKzLuXE"
        ),
        Article(
            title = "Unraveling the Mysteries of Ancient Civilizations",
            desc = "Uncover the enigmatic past of ancient civilizations through archaeological discoveries and historical insights.",
            date = "February 5, 2024",
            imageUrl = "https://media.licdn.com/dms/image/D5612AQHOMci6-sRDBw/article-cover_image-shrink_720_1280/0/1696967991289?e=2147483647&v=beta&t=OEpb2n0UL1wTrhN_UqGv2wMCayGd1_Id1RLRYIXhC2M"
        )
    )

     */
}