package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.layout.ContentScale
import android.R.attr.start
import android.R.attr.end
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background
                ) {
                ComposeArticleApp()// ye main screen ko show ya call krega jo real ui hai use
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() { // ye hmne app ke naam se composable function bnaya jisme app me jo cheeje hogi ve kha set or kase hogi vo set kia
        ArticleCard( // fir ye ArticleCard naam se function bnaya jisme ap me aane wli sbhi chije contain hogi
            title = stringResource(R.string.title_jetpack_compose_tutorial),//app ka title mtlb kis baare me ise string resource se bnaya mtlb string.xml me jaake kia same niche walo ko teeno ko
            shortDescription = stringResource(R.string.compose_short_desc),//ye ui ka hesding k baad phla paragrapgh hai jise string.xml me likha hmne string resource ki help se
            longDescription = stringResource(R.string.compose_long_desc),// ye second paragraph hai jise string.xml me likha  stringResources se pr usme hi paragraph likha yha nhi likha jayega same teeno hue ye
            imagePainter = painterResource(R.drawable.coverimageandroid)//Ye image load krne k lie rea-> drawable function folder se
        )
    }
@Composable
fun ArticleCard( // ye hai hmara upr bna article card function jisme hm use task dge ki kya line kiske liye hai
    title: String,// ye title ko string dene k lie jo uor title = stringResource(r.string.title_jetpack_compose_tutorial) hai use call krega jo usme Jetpack Compose Tutorial ko heading bnai hai use dikhane k lie
    shortDescription: String,// ye first paragraph likhega jo shortDescription = stringresource(r.string.compose_short_desc) ko call krke string.xml se ui me dikhayega same title ko bhi vhi se call kia hai isne
    longDescription: String,// ye second paragraph ke lie hai same cheej krega
    imagePainter: Painter,// isne upr wale imagePainter= painterResource(R.drawable.coveriamgeandroid) se image ko call kia or ui pe set kiaya call kia bss or sbsse upr dihayega kuki niche oahla image ko hi function call kia hai or or vo ise call krega ye upr wale ko tb aise sbse pehle image show hgi ui me
    modifier: Modifier = Modifier,// is wale modifier ne column wale modifier ko jo uske andr hai ststus bar se pahle uski jgah ko ty krna hai jaise column se sbhi component image title ki heading first paragrapgh or second paragraph ek ke niche ek arrange kia or iamge ko bhi set kia bilkul midlle k hisab se
) {
    Column(modifier = modifier.statusBarsPadding()) {// isne sbhi image heading paragraphs ko ek ke niche ek arrange kia or or stsusBarPadding() ne screen ko phone ki screen k hisab se bilkul sahi arrange krna jaise upr ki line battery or network ali alg dikhaana bina overlap kre
        Image(// ye image function upr imagePainter ko call krega or vo upr wale ko call krega or use sahi trike se arrange krega ye Image function or ui pe dikhayega
            painter = imagePainter, //ye dekho painter naam ke function ne  image painter ko kia or upr imagepainter ne usse upr wale ko kia hai aisa image dikahyega or ye or set krega
            contentDescription = null,// iska kaam sirf image ko decoration purpose se dikhana hai scree pe islie null hai jisse click krne oer koi option na aage badhe bss
            modifier = Modifier.fillMaxWidth(),// iska kaam  image ko screen ki puri chodai me stretch krna hai
            contentScale = ContentScale.FillWidth// iska kaam  lest or right me bache space jo ki fillMaxwidth ke baad bch jata hai use fill krna hai image ko usme stretch krke
        )
        Text(
            text = title,// ye title ko call krega or title apne stringResources wle function ko aise heading call hogi
            Modifier.padding(16.dp),// ye title ke charo or space dene k lie kuki all =16.dp likha hai to mtlb cahro or
            fontSize = 29.sp// ye words ka size hai
        )
        Text(
            text = shortDescription, // ye 1st paragraph ko call krega shortDescription naam se hai jo upr or fir upr waala ko call krega then ui pe print hoga
            modifier = Modifier.padding(start = 16.dp, end = 16.dp), // ye start or end me mtlb left or right me spacedega paragraph me 1st wale
            textAlign = TextAlign.Justify // iska kaam text paragraph ke dono side left right me equal space align krna hai
        )
        Text(
            text = longDescription,// ye 2nd paragraph ko call krga or vo usse upr wale ko call krega fir R.string wale ko long wale ko fir vo ui me dikhayega
            modifier = Modifier.padding(16.dp),// ye charo trf space dega 2nd paragraph ko
            textAlign = TextAlign.Justify// ye fir lest or right me space dega equal words ko bhi deta hai
        )
    }
}
    @Preview(showBackground = true,
        showSystemUi = true
    )
    @Composable
    fun ComposeArticlePreview() {
        ComposeArticleTheme {
            ComposeArticleApp()
        }
    }
// <resources>
//    <string name="app_name">Compose Article</string>
//    <string name="title_jetpack_compose_tutorial">Jetpack Compose Tutorial</string>
//    <string name="compose_short_desc">Jetpack Compose is a modern toolkit for building native Android UI...</string>
//    <string name="compose_long_desc">In this tutorial, you build a simple UI component...</string>
//</resources>    inme add kia string Resources khte hai string.xml ke andr hote hai ye inka kaam hardcoded strings code ke andr na likhni pde islie hota hai mtlb hardcoded ki code me strings na likh ke string.xml me likhna jisse use phone har ek another language me convert kr ske or code jada boilerplate type na lge islie or call krna R.string is trike se 