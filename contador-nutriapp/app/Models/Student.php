<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Student extends Model
{
    use HasFactory;

    /**
     * Campos que podem ser preenchidos massivamente.
     */
    protected $fillable = ['name', 'rm', 'meal_choice'];
}
