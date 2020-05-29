package alistar.core.usecases

open abstract class UseCase<Request, Response> {

    abstract fun execute(request: Request, response: ((Response) -> Unit))

}