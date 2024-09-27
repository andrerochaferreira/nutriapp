<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\API\StudentController;

Route::get('/', function () {
    return view('welcome');
});



// Rotas de API para alunos
Route::apiResource('students', StudentController::class);
Route::get('/students', [StudentController::class, 'index']); // Lista todos os estudantes
Route::post('/students', [StudentController::class, 'store']); // Cria um novo estudante
Route::get('/students/{id}', [StudentController::class, 'show']); // Mostra um estudante específico
Route::put('/students/{id}', [StudentController::class, 'update']); // Atualiza um estudante existente
Route::delete('/students/{id}', [StudentController::class, 'destroy']); // Deleta um estudante