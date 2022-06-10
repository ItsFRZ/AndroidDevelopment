package com.itsfrz.recyclervievrevision12

class GenerateDataset {


    fun getRandomStudent(noOfStudent : Int) : ArrayList<Student> {

        val studentList : ArrayList<Student> = ArrayList<Student>()


        val names : Array<String> = arrayOf("Faraz Sheikh","Faisal Sheikh","Hasnain Sheikh","Athar Sayyad","Affan Sayyad")
        val ages : Array<Int> = arrayOf(22,23,25,18,19)
        val year : Array<Int> = arrayOf(1,2,3,4)
        val branch : Array<String> = arrayOf("Computer Science & Engineering","Mechanical Engineering","Civil Engineering","Chemical Engineering","Fire Engineering")


        for (i in 0..noOfStudent){

            val randomName = getRandomName(names)
            val randomAge =  getRandomAge(ages)
            val randomBranch = getRandomBranch(branch)
            val randomYear = getRandomYear(year)
            val randomSkill = getRandomSkills()
            studentList.add(Student(randomName,randomAge,randomBranch,randomYear,randomSkill))
        }

        return studentList
    }

    private fun getRandomBranch(branchs : Array<String>): String {
        return branchs.get((0..branchs.size-1).random())
    }

    private fun getRandomAge(ages : Array<Int>): Int {
        return ages.get((0..ages.size-1).random())
    }


    private fun getRandomName(names : Array<String>): String {
        return names.get((0..names.size-1).random())
    }

    private fun getRandomYear(years : Array<Int>): Int {
        return years.get((0..years.size-1).random())
    }

    private fun getRandomSkills(): List<Skill> {
        val skills : Array<Skill> = arrayOf(
            Skill("Java"),
            Skill("Python"),
            Skill("Android"),
            Skill("Web"),
            Skill("Angular"),
            Skill("React"))
        val random = (0..5).random()
        skills.get(random)

        val randomSkill : ArrayList<Skill> = ArrayList<Skill>()
        for (i in 0..random){
            val skill : Skill = skills.get((0..random).random())
            randomSkill.add(skill)
        }
        return randomSkill
    }



}