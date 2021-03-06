import ar.edu.unahur.obj2.impostoresPaises.api.CurrencyConverterAPI
import ar.edu.unahur.obj2.impostoresPaises.api.RestCountriesAPI
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

// Algunos ejemplos para que jueguen un poco
// con lo que devuelve la API

val api = RestCountriesAPI()
api.buscarPaisesPorNombre("guay")
api.paisConCodigo("CHL")

val currencyApi = CurrencyConverterAPI("poné acá la API key")
// PEN es el código del sol peruano
currencyApi.convertirDolarA("PEN")
class ObservatorioTest: DescribeSpec({

    val argentina = Pais("Argentina", "ARG", 45380000, 2780000.0, "America", "SRA", 128.22)

    val brasil = Pais("Brasil", "BRA", 212600000, 851600000.0, "America", "BRL", 5.40)

    val uruguay = Pais("Uruguay", "URY", 3474000, 176215.0, "America", "UYU", 41.09)

    val bolivia = Pais("Bolivia", "BOL", 11670000, 1099000000.0, "America", "BOB", 6.88)

    val cuba = Pais("Cuba", "CUB", 11330000, 113860.0, "America", "CUP", 23.96)

    //Idiomas Paises
    argentina.idiomasOficiales.add("Español")
    brasil.idiomasOficiales.add("Portugues")
    uruguay.idiomasOficiales.add("Español")
    bolivia.idiomasOficiales.add("Español")
    bolivia.idiomasOficiales.add("Aimara")
    bolivia.idiomasOficiales.add("guaraní")
    cuba.idiomasOficiales.add("Español")

    //Paises Limitrofes
    argentina.paisesLimitrofes.add(uruguay)
    argentina.paisesLimitrofes.add(bolivia)
    brasil.paisesLimitrofes.add(uruguay)
    uruguay.paisesLimitrofes.add(argentina)
    uruguay.paisesLimitrofes.add(brasil)
    bolivia.paisesLimitrofes.add(argentina)
    bolivia.paisesLimitrofes.add(brasil)

    //Bloques regionales
    argentina.bloquesRegionales.add("OEA")
    brasil.bloquesRegionales.add("OEA")
    uruguay.bloquesRegionales.add("OEA")
    bolivia.bloquesRegionales.add("OEA")
    cuba.bloquesRegionales.add("UNASUR")

    describe("Observatorio tests") {
        it("Pais con nombre") {
            Observatorio.paisConNombre("Brasil").shouldBe(brasil)
            Observatorio.paisConNombre("Argentina").shouldBe(argentina)
            Observatorio.paisConNombre("Uruguay").shouldBe(uruguay)
        }
    }
})