<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\Controller;
use App\Models\Student;
use Illuminate\Http\Request;

class StudentController extends Controller
{
    /**
     * Listar todos os alunos.
     */
    public function index()
    {
        return response()->json(Student::all(), 200);
    }

    /**
     * Armazenar um novo aluno.
     */
    public function store(Request $request)
    {
        // Validação dos dados recebidos
        $request->validate([
            'name' => 'required|string|max:255',
            'rm' => 'required|string|max:50|unique:students,rm',
            'meal_choice' => 'required|in:Café da Manhã,Almoço,Café da Tarde',
        ]);

        // Criação do aluno
        $student = Student::create($request->all());

        return response()->json($student, 201);
    }

    /**
     * Mostrar um aluno específico.
     */
    public function show($id)
    {
        $student = Student::find($id);

        if (!$student) {
            return response()->json(['message' => 'Aluno não encontrado'], 404);
        }

        return response()->json($student, 200);
    }

    /**
     * Atualizar um aluno existente.
     */
    public function update(Request $request, $id)
    {
        $student = Student::find($id);

        if (!$student) {
            return response()->json(['message' => 'Aluno não encontrado'], 404);
        }

        // Validação dos dados recebidos
        $request->validate([
            'name' => 'sometimes|required|string|max:255',
            'rm' => 'sometimes|required|string|max:50|unique:students,rm,' . $id,
            'meal_choice' => 'sometimes|required|in:Café da Manhã,Almoço,Café da Tarde',
        ]);

        // Atualização do aluno
        $student->update($request->all());

        return response()->json($student, 200);
    }

    /**
     * Deletar um aluno.
     */
    public function destroy($id)
    {
        $student = Student::find($id);

        if (!$student) {
            return response()->json(['message' => 'Aluno não encontrado'], 404);
        }

        $student->delete();

        return response()->json(['message' => 'Aluno deletado com sucesso'], 200);
    }
}
