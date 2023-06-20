pipeline {
  agent {
    label "dind"
  }
  
  parameters {
    string(
      name: "branch_name",
      description: "Branch name to checkout",
      defaultValue: "master"
    )
  }

  stages {
    stage("Checkout") {
      steps {
        git(
            branch: params.branch_name,
            credentialsId: 'ssh-key',
            url: "git@github.com:user4353fd/user4353fd-react-redux-realworld-example-app.git",
                       
        )
      }
    }

    stage("Build docker image") {
      steps {
        script {
          docker.build "react-app:test"
        }
      }
    }
  }
}

// pipeline {
//   agent {
//     label "dind"
//   }
  
//   parameters {
//     string(
//       name: "branch_name",
//       description: "Branch name to checkout",
//       defaultValue: "master"
//     )
//   }

//   stages {
//     stage("Checkout") {
//       steps {
//         sshagent(credentials: ['ssh-key']) {
//           sh 'git clone git@github.com:user4353fd/user4353fd-react-redux-realworld-example-app.git'
//         }
//       }
//     }

//     stage("Build docker image") {
//       steps {
//         script {
//           docker.build "react-app:test"
//         }
//       }
//     }
  


//     stage("Build docker image") {
//       steps {
//         script {
//           docker.build "react-app:test"
//         }
//       }
//     }
//   }
// }
